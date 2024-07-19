package com.nagarro.notesapp.service;

import com.nagarro.notesapp.model.entity.User;

import java.sql.SQLIntegrityConstraintViolationException;


public interface UserService {

    public User createUser(User user) throws SQLIntegrityConstraintViolationException;

    public User getUserByUsername(String username);
}
