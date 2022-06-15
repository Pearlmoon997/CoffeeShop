package com.example.CoffeeShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;        //로그인 ID

    @Column
    private String name;

    @Column
    private Integer age;

    @Column
    private String phoneNum;

    @Column
    private String password;

    public void patch(Member member) {
        if (member.userName != null) {
            this.userName = member.userName;
        }
        if (member.name != null) {
            this.name = member.name;
        }
        if (member.age != null) {
            this.age = member.age;
        }
        if (member.phoneNum != null) {
            this.phoneNum = member.phoneNum;
        }
        if (member.password != null) {
            this.password = member.password;
        }
    }
}
