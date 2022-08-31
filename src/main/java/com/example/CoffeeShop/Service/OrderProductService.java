package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.OrderProductDto;
import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Entity.OrderProduct;
import com.example.CoffeeShop.Entity.Product;
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

    public List<OrderProduct> listByOrderId(Long userId) {
        return orderProductRepository.listByOrderId(userId);
    }

    //주문 등록
    @Transactional
    public OrderProductDto create(Long OrderId, Long ProductId, OrderProductDto dto) {
        Order order = orderRepository.findById(OrderId)
                .orElseThrow(() -> new IllegalArgumentException("대상 주문이 없음"));
        Product product = productRepository.findById(ProductId)
                .orElseThrow(() -> new IllegalArgumentException("대상 상품이 없음"));

        OrderProduct orderProduct = OrderProduct.createOrderProduct(dto, order, product);

        OrderProduct created = orderProductRepository.save(orderProduct);

        return OrderProductDto.createOrderProductDto(created);
    }

    //삭제
    @Transactional
    public OrderProduct delete(Long id) {
        OrderProduct target = orderProductRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        orderProductRepository.delete(target);

        return target;
    }

}
