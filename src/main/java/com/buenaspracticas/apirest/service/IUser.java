package com.buenaspracticas.apirest.service;
import com.buenaspracticas.apirest.models.dto.UserDto;
import com.buenaspracticas.apirest.models.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUser {

    User save(UserDto user);
    User findById(Integer id);
    void delete(User user);

    List<User> getAll();

}
