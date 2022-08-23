package com.example.CoffeeShop.Controller;

import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Entity.Product;
import com.example.CoffeeShop.Service.OrderProductService;
import com.example.CoffeeShop.Service.OrderService;
import com.example.CoffeeShop.Service.ProductService;
import com.example.CoffeeShop.config.auth.DTO.SessionUser;
import com.example.CoffeeShop.config.auth.LoginUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    @Autowired
    private ProductService productService;


    @Autowired
    private OrderService orderService;

    //메인 페이지
    @GetMapping("/")
    public String main(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "coffeeShop/main";
    }

    //로그인 페이지
    @GetMapping("/signIn")
    public String login() {

        return "coffeeShop/login";
    }

    //베스트 상품 페이지
    @GetMapping("/best")
    public String best() {
        return "coffeeShop/best";
    }

    //모든 상품 페이지
    @GetMapping("/product")
    public String product(Model model, @LoginUser SessionUser user) {    //모델 등록
        List<Product> products = productService.list();
        model.addAttribute("products", products);
        List<Order> order = orderService.list();
        model.addAttribute("order", order);
        if (user != null) {
            model.addAttribute("userId", user.getId());
        }
        return "coffeeShop/product";
    }


}
