package com.nagarro.notesapp.controller;


import com.nagarro.notesapp.model.dto.JwtRequest;
import com.nagarro.notesapp.model.dto.JwtResponse;
import com.nagarro.notesapp.model.dto.Response;
import com.nagarro.notesapp.security.JwtUtil;
import com.nagarro.notesapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<Map<Object, Object>> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        JwtResponse jwtResponse =  new JwtResponse(token, userDetails.getUsername());
        Map<Object, Object> res = new HashMap<>();
        res.put(Response.success, true);
        res.put(Response.data, jwtResponse);
        res.put(Response.message, "Login Successful");
        return ResponseEntity.ok(res);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public Map<Object, Object> exceptionHandler() {
        return new HashMap<Object, Object>(){{
            put(Response.success, false);
            put(Response.data, null);
            put(Response.message, "Invalid Username or Password");
        }
        };
    }

}
