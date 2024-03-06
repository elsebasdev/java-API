package com.buenaspracticas.apirest.models.dao;

import com.buenaspracticas.apirest.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<User, Integer> {



}
