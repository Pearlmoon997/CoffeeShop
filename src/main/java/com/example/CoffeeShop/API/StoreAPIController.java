package com.example.CoffeeShop.API;

import com.example.CoffeeShop.DTO.StoreDto;
import com.example.CoffeeShop.Entity.Store;
import com.example.CoffeeShop.Service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StoreAPIController {

    @Autowired
    private StoreService storeService;

    //전체 지점 조회
    @GetMapping("/api/stores")
    public List<Store> list() {
        return storeService.list();
    }

    //지역 별 지점 조회
    @GetMapping("/api/stores/{location}")
    public List<Store> listByLocation(@PathVariable String location) {
        return storeService.listByLocation(location);
    }

    //지점 등록
    @PostMapping("/api/store")
    public ResponseEntity<Store> create(@RequestBody StoreDto dto) {
        Store created = storeService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //지점 수정
    @PatchMapping("/api/store/{id}")
    public ResponseEntity<Store> update(@PathVariable Long id, @RequestBody StoreDto dto) {
        Store updated = storeService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //지점 삭제
    @DeleteMapping("/api/store/{id}")
    public ResponseEntity<Store> delete(@PathVariable Long id) {
        Store deleted = storeService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
