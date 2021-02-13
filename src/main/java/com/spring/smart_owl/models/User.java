package com.spring.smart_owl.models;

import com.spring.smart_owl.dao.email_validator.ValidEmail;
import com.spring.smart_owl.dao.password_validator.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {
    private int id;

    @NotEmpty(message = "First name should not be empty!")
    private String first_name;

    @NotEmpty(message = "First name should not be empty!")
    private String last_name;

    private String email;

    private String password;


    public User(int id, String first_name, String last_name, String password, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
