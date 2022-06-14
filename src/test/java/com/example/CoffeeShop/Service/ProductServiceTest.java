package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.ProductDto;
import com.example.CoffeeShop.Entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    void list() {
        Product a = new Product(1L, "에스프레소", 4000, "커피");
        Product b = new Product(2L, "아메리카노", 4500, "커피");
        Product c = new Product(3L, "라떼", 4800, "커피");
        Product d = new Product(4L, "아이스티", 3800, "Non 커피");
        Product e = new Product(5L, "우유", 2000, "Non 커피");
        List<Product> expected = Arrays.asList(a, b, c, d, e);

        List<Product> actual = productService.list();

        assertEquals(expected.toString(), actual.toString());
        System.out.println(actual);
    }

    @Test
    void findByCategory() {
        String category = "커피";

        Product a = new Product(1L, "에스프레소", 4000, "커피");
        Product b = new Product(2L, "아메리카노", 4500, "커피");
        Product c = new Product(3L, "라떼", 4800, "커피");
        List<Product> expected = Arrays.asList(a, b, c);

        List<Product> actual = productService.findByCategory(category);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void create() {
        String name = "피자맛 아이스티";
        int price = 3000;
        String category = "Non 커피";
        ProductDto dto = new ProductDto(null, name, price, category);
        Product expected = new Product(6L, name, price, category);

        Product actual = productService.create(dto);

        assertEquals(expected.toString(), actual.toString());
    }
}