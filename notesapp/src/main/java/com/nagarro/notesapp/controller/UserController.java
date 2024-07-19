package com.nagarro.notesapp.controller;

import com.nagarro.notesapp.model.entity.User;
import com.nagarro.notesapp.model.dto.Response;
import com.nagarro.notesapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<Map<Object, Object>> registerUser(@RequestBody User user){
        Map<Object, Object> res = new HashMap<>();
        try {
            User createdUser = userService.createUser(user);
            res.put(Response.success, true);
            res.put(Response.data, createdUser);
            res.put(Response.message, "Registration Successful");
            return ResponseEntity.ok(res);
        }
        catch(SQLIntegrityConstraintViolationException e){
            res.put(Response.success, false);
            res.put(Response.data, null);
            res.put(Response.message, "User Already exists. Please Login..");
        }
        return ResponseEntity.ok(res);

    }

}
