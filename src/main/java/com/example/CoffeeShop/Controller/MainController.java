package com.example.CoffeeShop.Controller;

import com.example.CoffeeShop.config.auth.DTO.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    private final HttpSession httpSession;

    //메인 페이지
    @GetMapping("/")
    public String main(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        if (user != null) {
            model.addAttribute("userEmail", user.getEmail());
        }
        return "coffeeShop/main";
    }

    //로그인 페이지
    @GetMapping("/signIn")
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
