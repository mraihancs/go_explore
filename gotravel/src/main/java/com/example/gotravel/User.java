package com.example.gotravel;


import java.io.Serializable;

public class User implements Serializable {

    public String name;
    public String email;
    public String username;
    public String password;

    User(String name, String email, String username, String password){
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}
