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
    private String userName;
    private Integer age;
    private String phoneNum;
    private String password;
    private Role role;

    public User toEntity() {
        return new User(id, email, userName, age, phoneNum, password, role);
    }
}
