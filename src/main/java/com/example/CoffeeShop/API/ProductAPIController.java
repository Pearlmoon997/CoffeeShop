package com.example.CoffeeShop.API;

import com.example.CoffeeShop.Entity.Product;
import com.example.CoffeeShop.Repository.ProductRepository;
import com.example.CoffeeShop.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductAPIController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> list() {
        return productService.list();
    }
}
