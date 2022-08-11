package com.example.CoffeeShop.Repository;

import com.example.CoffeeShop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    //이미 있는 사용자인지 확인
    Optional<User> findByEmail(String email);
}
