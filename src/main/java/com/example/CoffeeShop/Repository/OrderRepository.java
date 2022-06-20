package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
