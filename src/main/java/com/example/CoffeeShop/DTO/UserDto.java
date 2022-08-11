package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.UserManage.Role;
import com.example.CoffeeShop.Entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class UserDto {
    private Long id;
    private String token;
    private String name;
    private String birth;
    private String phoneNum;
    private Role role;

    public User toEntity() {
        return new User(id, token, name, birth, phoneNum, role);
    }
}
