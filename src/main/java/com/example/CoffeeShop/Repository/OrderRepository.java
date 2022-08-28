package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.Order;
import com.example.CoffeeShop.Entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //회원 전화번호 별 주문 조회
    @Query(value = "SELECT * FROM orders WHERE user_id = " +
            "(SELECT id FROM user WHERE phone_num = :PhoneNum);", nativeQuery = true)
    List<Order> findByPhoneNum(@Param("PhoneNum")String PhoneNum);

    @Query(value = "SELECT id FROM orders WHERE user_id = (SELECT id FROM user WHERE name = :Name)", nativeQuery = true)
    List<Order> findByName(@Param("Name")String Name);

}
