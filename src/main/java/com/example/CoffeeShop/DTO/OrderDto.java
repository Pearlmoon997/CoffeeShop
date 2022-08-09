package com.example.CoffeeShop.DTO;

import com.example.CoffeeShop.Entity.Order;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class OrderDto {
    private Long id;

    @JsonProperty("member_id")
    private Long memberId;

    @JsonProperty("store_id")
    private Long storeId;

    private LocalDateTime orderDate;

    public static OrderDto createOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getMember().getId(),
                order.getStore().getId(),
                order.getOrderDate()
        );
    }
}
