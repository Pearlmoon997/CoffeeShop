package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.OrderDto;
import com.example.CoffeeShop.Entity.User;
import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Repository.UserRepository;
import com.example.CoffeeShop.Repository.OrderProductRepository;
import com.example.CoffeeShop.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;


    //전체 주문 조회
    public List<Order> list() {
        return orderRepository.findAll();
    }

    //회원 전화번호 별 주문 조회
    public List<Order> findByPhoneNum(String PhoneNum) {
        return orderRepository.findByPhoneNum(PhoneNum);
    }


    //주문 생성
    @Transactional
    public OrderDto create(Long userId, OrderDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("생성 실패, 대상 회원이 없음"));

        Order order = Order.createOrder(dto, user);

        Order created = orderRepository.save(order);

        return OrderDto.createOrderDto(created);
    }

    //주문 삭제
    @Transactional
    public Order delete(Long id) {
        Order target = orderRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        orderRepository.delete(target);

        return target;
    }

}
