package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.OrderDto;
import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderAPIController {

    @Autowired
    private OrderService orderService;

    //전체 주문 조회
    @GetMapping("/api/orders")
    public List<Order> list() {
        return orderService.list();
    }

    //회원 전화번호 별 주문 조회
    @GetMapping("/api/orders/{PhoneNum}")
    public List<Order> listByPhone(@PathVariable String PhoneNum) {
        return orderService.findByPhoneNum(PhoneNum);
    }


    //주문 생성
    @PostMapping("/api/orders/{userId}")
    public ResponseEntity<OrderDto> create(@PathVariable Long userId, @RequestBody OrderDto dto) {
        OrderDto createdDto = orderService.create(userId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //주문 삭제
    @DeleteMapping("/api/orders/{id}")
    public ResponseEntity<Order> delete(@PathVariable Long id) {
        Order deleted = orderService.delete(id);
        return deleted != null ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
