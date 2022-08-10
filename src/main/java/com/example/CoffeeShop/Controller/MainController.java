package com.example.CoffeeShop.Controller;

import com.example.CoffeeShop.Entity.Member;
import com.example.CoffeeShop.Service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {

    //메인 페이지
    @GetMapping("/main")
    public String main() {
        return "coffeeShop/main";
    }

    //로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "coffeeShop/login";
    }

    //회원가입 페이지
    @GetMapping("/signUp")
    public String signUp() {
        return "coffeeShop/signUp";
    }

    //베스트 상품 페이지
    @GetMapping("/best")
    public String best() {
        return "coffeeShop/best";
    }

    //모든 상품 페이지
    @GetMapping("/product")
    public String product() {
        return "coffeeShop/product";
    }

    //지점 정보
    @GetMapping("/store")
    public String store() {
        return "coffeeShop/store";
    }

}
