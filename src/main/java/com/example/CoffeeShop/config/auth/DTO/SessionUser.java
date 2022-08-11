package com.example.CoffeeShop.config.auth.DTO;

import com.example.CoffeeShop.Entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(User user) {
        this.name = user.getUserName();
        this.email = user.getEmail();
    }
}