package com.nagarro.notesapp.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.notesapp.model.dto.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        Map<Object, Object> errorRes = new HashMap<>();
        errorRes.put(Response.success, false);
        errorRes.put(Response.data, null);
        errorRes.put(Response.message, authException.getMessage());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRes = objectMapper.writeValueAsString(errorRes);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(201);
        response.getWriter().write(jsonRes);

    }
}
