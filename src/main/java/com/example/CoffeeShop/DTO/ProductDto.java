package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.Product;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private String category;

    public Product toEntity() {
        return new Product(id, name, price, category);
    }

}
