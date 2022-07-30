package com.example.CoffeeShop.API;

import com.example.CoffeeShop.Entity.OrderProduct;
import com.example.CoffeeShop.Service.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class OrderProductAPIController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/api/orderproducts")
    public List<OrderProduct> list() {
        return orderProductService.list();
    }
}
