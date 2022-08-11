package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.MemberManage.Role;
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
    private String email;
    private String name;
    private String age;
    private String phoneNum;
    private Role role;

    public User toEntity() {
        return new User(id, email, name, age, phoneNum, role);
    }
}
