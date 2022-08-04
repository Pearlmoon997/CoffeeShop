package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.OrderProduct;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class OrderProductDto {
    private Long id;

    @JsonProperty("order_id")
    private Long OrderId;

    @JsonProperty("product_id")
    private Long ProductId;

    @JsonProperty("total")
    private int Total;

    public static OrderProductDto createOrderProductDto(OrderProduct created) {
        return new OrderProductDto(
                created.getId(),
                created.getOrder().getId(),
                created.getProduct().getId(),
                created.getTotal()
        );
    }
}
