package com.example.CoffeeShop.Controller;

import com.example.CoffeeShop.DTO.OrderDto;
import com.example.CoffeeShop.DTO.OrderProductDto;
import com.example.CoffeeShop.DTO.ProductDto;
import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Entity.OrderProduct;
import com.example.CoffeeShop.Entity.Product;
import com.example.CoffeeShop.Repository.OrderRepository;
import com.example.CoffeeShop.Service.OrderProductService;
import com.example.CoffeeShop.Service.OrderService;
import com.example.CoffeeShop.Service.ProductService;
import com.example.CoffeeShop.config.auth.DTO.SessionUser;
import com.example.CoffeeShop.config.auth.LoginUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {

    @Autowired
    private ProductService productService;


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProductService orderProductService;



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

        //올바른 User ID 인지 확인
        if (user != null) {
            model.addAttribute("userId", user.getId());
            model.addAttribute("userName", user.getName());
        }

        return "coffeeShop/product";
    }

    //주문하기
    @PostMapping("/order/product")
    public ResponseEntity<OrderDto> create(@LoginUser SessionUser user, @RequestBody Map<String, Long> map, OrderDto dto,
                                           OrderProductDto orderDto) {

        // JSON 데이터 잘 매핑됐는지 확인
        log.info("map ->" + map);

        //Order 테이블 Insert
        OrderDto createdDto = orderService.create(user.getId(), dto);

        //Order_product 테이블 Insert
        OrderProductDto createdDto2 = orderProductService.create(createdDto.getId(), map.get("productId"), orderDto);
        log.info("orderProduct -> " + createdDto2);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //마이 페이지
    @GetMapping("/myPage")
    public String myPage(@LoginUser SessionUser user, Model model) throws Exception{
        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("userName", user.getName());
        }

        List<Order> orderProducts = orderService.findByPhoneNum(user.getPhoneNum());
        model.addAttribute("order", orderProducts);

        List<OrderProduct> orderProducts2 = orderProductService.listByOrderId(user.getId());
        model.addAttribute("orderP", orderProducts2);


        return "coffeeShop/myPage";
    }

}
