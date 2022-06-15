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

    //상품 전체 조회
    @GetMapping("/api/products")
    public List<Product> list() {
        return productService.list();
    }

    //카테고리 별 상품 조회
    @GetMapping("/api/products/{category}")
    public List<Product> showByCategory(@PathVariable String category) {
        return productService.findByCategory(category);
    }

    //상품 등록
    @PostMapping("/api/products")
    public ResponseEntity<Product> create(@RequestBody ProductDto dto) {
        Product created = productService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //상품 수정
    @PatchMapping("/api/products/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDto dto) {
        Product updated = productService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //상품 삭제
    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product deleted = productService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST). build();
    }
}
