package com.nagarro.notesapp.model.dto;

public class JwtResponse {

    private String jwtToken;
    private String username;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    public String getToken() {
        return jwtToken;
    }

    public void setToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
