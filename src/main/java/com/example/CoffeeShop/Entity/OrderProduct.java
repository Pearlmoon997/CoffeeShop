package com.example.CoffeeShop.Entity;

import com.example.CoffeeShop.DTO.OrderProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Entity
@Table (name = "OrderProduct")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private int Total;

    public static OrderProduct createOrderProduct(OrderProductDto dto, Order order, Product product) {
        return new OrderProduct(
                dto.getId(),
                order,
                product,
                product.getPrice()
        );
    }
}
