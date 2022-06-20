package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.OrderDto;
import com.example.CoffeeShop.Entity.Member;
import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Repository.MemberRepository;
import com.example.CoffeeShop.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public OrderDto create(Long memberId, OrderDto dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("생성 실패, 대상 회원이 없음"));

        Order order = Order.createOrder(dto, member);

        Order created = orderRepository.save(order);

        return OrderDto.createOrderDto(created);
    }
}
