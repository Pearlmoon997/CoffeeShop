package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.OrderProductDto;
import com.example.CoffeeShop.Entity.OrderProduct;
import com.example.CoffeeShop.Service.OrderProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class OrderProductAPIController {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/api/orderproducts")
    public List<OrderProduct> list() {
        return orderProductService.list();
    }

    @GetMapping("/api/orderproducts/{userId}")
    public List<OrderProduct> listByOrderId(@PathVariable Long userId){
        return orderProductService.listByOrderId(userId);
    }

    //order_product 등록
    @PostMapping("/api/orderproducts/{orderId}/{productId}")
    public ResponseEntity<OrderProductDto> create(@PathVariable Long orderId, @PathVariable Long productId,
                                                  @RequestBody OrderProductDto dto) {
        OrderProductDto createdDto = orderProductService.create(orderId, productId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //order_product 삭제
    @DeleteMapping("/api/orderproducts/{id}")
    public ResponseEntity<OrderProduct> delete(@PathVariable Long id) {
        OrderProduct deleted = orderProductService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
