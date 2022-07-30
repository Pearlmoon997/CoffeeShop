package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.Entity.OrderProduct;
import com.example.CoffeeShop.Repository.OrderProductRepository;
import com.example.CoffeeShop.Repository.OrderRepository;
import com.example.CoffeeShop.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    //주문 목록
    public List<OrderProduct> list() {
        return orderProductRepository.findAll();
    }
}
