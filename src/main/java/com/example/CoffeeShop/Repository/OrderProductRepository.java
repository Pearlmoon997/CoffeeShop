package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    @Query(value = "SELECT * FROM Order_Product WHERE Order_Id = " +
            "(SELECT id FROM orders WHERE user_id = :userId)", nativeQuery = true)

    List<OrderProduct> listByOrderId(@Param("userId")Long userId);

}
