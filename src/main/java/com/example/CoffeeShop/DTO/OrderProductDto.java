package com.example.CoffeeShop.DTO;

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
    private Long orderId;

    @JsonProperty("product_id")
    private Long ProductId;

    private int Total;
}
