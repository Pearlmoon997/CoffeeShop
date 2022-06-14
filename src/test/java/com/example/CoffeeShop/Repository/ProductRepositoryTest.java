package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("모든 상품 조회")
    void findAll() {
        Product a = new Product(1L, "에스프레소", 4000, "커피");
        Product b = new Product(2L, "아메리카노", 4500, "커피");
        Product c = new Product(3L, "라떼", 4800, "커피");
        Product d = new Product(4L, "아이스티", 3800, "Non 커피");
        Product e = new Product(5L, "우유", 2000, "Non 커피");
        List<Product> expected = Arrays.asList(a, b, c, d, e);

        List<Product> actual = productRepository.findAll();

        assertEquals(expected.toString(), actual.toString());
        System.out.println(actual);
    }

    @Test
    @DisplayName("카테고리 별 상품 조회")
    void findByCategory() {
        String category = "커피";

        Product a = new Product(1L, "에스프레소", 4000, "커피");
        Product b = new Product(2L, "아메리카노", 4500, "커피");
        Product c = new Product(3L, "라떼", 4800, "커피");
        List<Product> expected = Arrays.asList(a, b, c);

        List<Product> actual = productRepository.findByCategory(category);

        assertEquals(expected.toString(), actual.toString());
        System.out.println(actual);
    }

}