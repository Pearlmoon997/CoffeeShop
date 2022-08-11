package com.example.CoffeeShop.Entity;

import com.example.CoffeeShop.Entity.UserManage.Role;
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
    private String token;        //네이버 토큰 값 ID

    @Column
    private String name;

    @Column
    private String birth;

    @Column
    private String phoneNum;

    //역할 추가
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    public void patch(User user) {
        if (user.token != null) {
            this.token = user.token;
        }
        if (user.name != null) {
            this.name = user.name;
        }
        if (user.birth != null) {
            this.birth = user.birth;
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
