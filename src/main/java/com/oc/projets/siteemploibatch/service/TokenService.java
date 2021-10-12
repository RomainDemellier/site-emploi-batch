package com.oc.projets.siteemploibatch.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String token = "";

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
