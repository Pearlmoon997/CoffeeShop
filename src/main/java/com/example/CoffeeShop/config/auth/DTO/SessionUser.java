package com.example.CoffeeShop.config.auth.DTO;

import com.example.CoffeeShop.Entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private Long id;
    private String name;
    private String token;
    private String phoneNum;

    public SessionUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.token = user.getToken();
        this.phoneNum = user.getPhoneNum();
    }
}
