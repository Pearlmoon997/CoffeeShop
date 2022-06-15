package com.example.CoffeeShop.Service;

import com.example.CoffeeShop.DTO.ProductDto;
import com.example.CoffeeShop.Entity.Product;
import com.example.CoffeeShop.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //전체 상품 조회
    public List<Product> list() {
        return productRepository.findAll();
    }

    //카테고리 별 상품 조회
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    //상품 등록
    @Transactional
    public Product create(ProductDto dto) {
        Product product = dto.toEntity();
        if (product.getId() != null) {
            return null;
        }

        return productRepository.save(product);
    }

    @Transactional
    public Product update(Long id, ProductDto dto) {
        Product product = dto.toEntity();
        log.info("id: {}, Product: {}", id, product.toString());

        Product target = productRepository.findById(id).orElse(null);
        if (target == null || id != product.getId()) {
            log.info("잘못된 요청");
            return null;
        }
        target.patch(product);
        Product updated = productRepository.save(target);
        return updated;
    }

    @Transactional
    public Product delete(Long id) {
        Product target = productRepository.findById(id).orElse(null);

        if (target == null) {
            return null;
        }
        productRepository.delete(target);

        return target;
    }
}
