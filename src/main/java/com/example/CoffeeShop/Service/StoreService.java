package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.StoreDto;
import com.example.CoffeeShop.Entity.Store;
import com.example.CoffeeShop.Repository.StoreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    //전제 지점 조회
    public List<Store> list() {
        return storeRepository.findAll();
    }

    //지역 별 지점 조회
    public List<Store> listByLocation(String location) {
        return storeRepository.findByLocation(location);
    }

    //지점 등록
    @Transactional
    public Store create(StoreDto dto) {
        Store store = dto.toEntity();
        if (store.getId() != null) {
            return null;
        }
        return storeRepository.save(store);
    }

    //지점 수정
    @Transactional
    public Store update(Long id, StoreDto dto) {
        Store store = dto.toEntity();
        Store target = storeRepository.findById(id).orElse(null);

        target.patch(store);
        Store updated = storeRepository.save(target);
        return updated;
    }

    //지점 삭제
    @Transactional
    public Store delete(Long id) {
        Store target = storeRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        storeRepository.delete(target);

        return target;
    }
}
