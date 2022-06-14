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
    private int price;

    @Column
    private String category;

}
