package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.UserDto;
import com.example.CoffeeShop.Entity.User;
import com.example.CoffeeShop.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserAPIController {

    @Autowired
    private UserService userService;

    //모든 회원 조회
    @GetMapping("/api/users")
    public List<User> list() {
        return userService.list();
    }

    //회원 등록
    @PostMapping("/api/users")
    public ResponseEntity<User> create(@RequestBody UserDto dto) {
        User created = userService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //회원 수정
    @PatchMapping("/api/users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody UserDto dto) {
        User updated = userService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //회원 삭제
    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User deleted = userService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
