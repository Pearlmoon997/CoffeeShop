package com.example.CoffeeShop.config.auth;

import com.example.CoffeeShop.Entity.MemberManage.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
//Spring Security 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() //h2 사용을 위한 옵션 비활성화
                .and().logout().logoutSuccessUrl("/") //로그아웃 성공 시 / 주소로 이동
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); //userInterface 구현체 등록
    }

}
