package com.example.CoffeeShop.Entity;

import com.example.CoffeeShop.DTO.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer price;

    @Column
    private String category;

    public void patch(Product product) {
        if (product.name != null) {
            this.name = product.name;
        }
        if (product.category != null) {
            this.category = product.category;
        }
        if (product.price != null) {
            this.price = product.price;
        }
    }
}
