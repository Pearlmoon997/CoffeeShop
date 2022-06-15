package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.Member;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class MemberDto {
    private Long id;
    private String userName;
    private String name;
    private Integer age;
    private String phoneNum;
    private String password;

    public Member toEntity() {
        return new Member(id, userName, name, age, phoneNum, password);
    }
}
