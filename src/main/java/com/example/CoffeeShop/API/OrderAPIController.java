package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.OrderDto;
import com.example.CoffeeShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAPIController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/members/{memberId}/orders")
    public ResponseEntity<OrderDto> create(@PathVariable Long memberId, @RequestBody OrderDto dto) {
        OrderDto createdDto = orderService.create(memberId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
}
