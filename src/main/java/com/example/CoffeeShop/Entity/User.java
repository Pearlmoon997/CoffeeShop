package com.example.CoffeeShop.Entity;

import com.example.CoffeeShop.Entity.MemberManage.Role;
import lombok.*;


import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;        //네이버 토큰 값 ID

    @Column
    private String name;

    @Column
    private String age;

    @Column
    private String phoneNum;

    //역할 추가
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    public void patch(User user) {
        if (user.email != null) {
            this.email = user.email;
        }
        if (user.name != null) {
            this.name = user.name;
        }
        if (user.age != null) {
            this.age = user.age;
        }
        if (user.phoneNum != null) {
            this.phoneNum = user.phoneNum;
        }

    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public Object update(String name) {
        this.name = name;

        return this;
    }

}
