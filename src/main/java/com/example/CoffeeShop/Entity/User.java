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
    private String email;        //로그인 ID

    @Column
    private String userName;

    @Column
    private Integer age;

    @Column
    private String phoneNum;

    @Column
    private String password;

    //역할 추가
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    public void patch(User user) {
        if (user.email != null) {
            this.email = user.email;
        }
        if (user.userName != null) {
            this.userName = user.userName;
        }
        if (user.age != null) {
            this.age = user.age;
        }
        if (user.phoneNum != null) {
            this.phoneNum = user.phoneNum;
        }
        if (user.password != null) {
            this.password = user.password;
        }
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public Object update(String name) {
        this.userName = name;

        return this;
    }

}
