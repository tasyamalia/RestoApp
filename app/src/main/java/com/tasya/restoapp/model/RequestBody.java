package com.tasya.restoapp.model;

public class RequestBody {
    private String email;
    private String password;

    public RequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
