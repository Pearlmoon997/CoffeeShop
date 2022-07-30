package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}
