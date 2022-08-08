package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    //지역별 지점 조회
    @Query(value = "SELECT * FROM store WHERE location = :location", nativeQuery = true)
    List<Store> findByLocation(@Param("location") String location);
}
