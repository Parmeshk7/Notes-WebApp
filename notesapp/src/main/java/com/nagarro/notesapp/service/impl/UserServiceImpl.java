package com.nagarro.notesapp.service.impl;

import com.nagarro.notesapp.model.entity.User;
import com.nagarro.notesapp.repository.UserRepository;
import com.nagarro.notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) throws SQLIntegrityConstraintViolationException {
        User existingUser = userRepository.findByUsername(user.getUsername()).orElse(null);
        if(existingUser != null){
            throw new SQLIntegrityConstraintViolationException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElse(null);
    }
}
