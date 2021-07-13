package com.example.Week2Demo.model;

public class Token {
    private final String jwt;

    public Token(String jwt) {
        this.jwt = jwt;
    }
    public String getJwt() {
        return jwt;
    }
}
