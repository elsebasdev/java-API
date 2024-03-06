package com.buenaspracticas.apirest.controller;

import com.buenaspracticas.apirest.models.dto.UserDto;
import com.buenaspracticas.apirest.models.entity.User;
import com.buenaspracticas.apirest.service.IUser;
import com.buenaspracticas.apirest.service.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private IUser userServices;

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody UserDto userdto){

        User userCreate = userServices.save(userdto);
        return userdto.builder()
                .id(userCreate.getId())
                .nombres(userCreate.getNombres())
                .apellidos(userCreate.getApellidos())
                .email(userCreate.getEmail())
                .Active(userCreate.isActive())
                .telefono(userCreate.getTelefono())
                .registrationDate(userCreate.getRegistrationDate())
                .password(userCreate.getPassword()).build();

    };

    @PutMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto update(@RequestBody UserDto userdto) {
        User userById = userServices.findById(userdto.getId());
        if (userById != null) {
            User userUpdate = userServices.save(userdto);
            return userdto.builder()
                    .id(userUpdate.getId())
                    .nombres(userUpdate.getNombres())
                    .apellidos(userUpdate.getApellidos())
                    .email(userUpdate.getEmail())
                    .Active(userUpdate.isActive())
                    .telefono(userUpdate.getTelefono())
                    .registrationDate(userUpdate.getRegistrationDate())
                    .password(userUpdate.getPassword()).build();
        }else {
            return userdto;
        }

    };

    @DeleteMapping("user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id){

        Map<String,Object> response = new HashMap<>();

        try {

            User userDelete  = userServices.findById(id);

            userServices.delete(userDelete);
            return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
        }catch(DataAccessException ex){

            response.put("mensaje",ex.getMessage());
            response.put("User",null);

            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    @GetMapping("user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@PathVariable Integer id){
        User user = userServices.findById(id);
        return UserDto.builder()
                .id(user.getId())
                .nombres(user.getNombres())
                .apellidos(user.getApellidos())
                .email(user.getEmail())
                .Active(user.isActive())
                .telefono(user.getTelefono())
                .registrationDate(user.getRegistrationDate())
                .password(user.getPassword()).build();
    }

    @GetMapping("users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userServices.getAll();
    }



}
