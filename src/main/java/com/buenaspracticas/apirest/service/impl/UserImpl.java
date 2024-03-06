package com.buenaspracticas.apirest.service.impl;
import com.buenaspracticas.apirest.models.dao.UsuarioDao;
import com.buenaspracticas.apirest.models.dto.UserDto;
import com.buenaspracticas.apirest.models.entity.User;
import com.buenaspracticas.apirest.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class UserImpl implements IUser {

    @Autowired
    private UsuarioDao usuarioDao;
    @Transactional
    @Override
    public User save(UserDto userdto) {
        User user = User.builder()
                    .id(userdto.getId())
                    .nombres(userdto.getNombres())
                    .apellidos(userdto.getApellidos())
                    .email(userdto.getEmail())
                    .Active(userdto.isActive())
                    .telefono(userdto.getTelefono())
                    .registrationDate(userdto.getRegistrationDate())
                    .password(userdto.getPassword()).build();
        return usuarioDao.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(User user) {
        usuarioDao.delete(user);

    }

    @Override
    public List<User> getAll() {
        return (List<User>) usuarioDao.findAll();
    }
}
