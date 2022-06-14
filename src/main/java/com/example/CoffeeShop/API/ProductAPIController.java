package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.ProductDto;
import com.example.CoffeeShop.Entity.Product;
import com.example.CoffeeShop.Repository.ProductRepository;
import com.example.CoffeeShop.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/api/products/{category}")
    public List<Product> showByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> create(@RequestBody ProductDto dto) {
        Product created = productService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }
}
