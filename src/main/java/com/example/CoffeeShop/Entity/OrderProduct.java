package com.example.CoffeeShop.Entity;

import com.example.CoffeeShop.DTO.OrderProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE) //cascade 옵션 -> OnDelete 옵션은 cascade = CascadeTYPE의 모든 조건을 충족!
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
