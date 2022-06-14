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

    public List<Product> list() {
        return productRepository.findAll();
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product create(ProductDto dto) {
        Product product = dto.toEntity();
        if (product.getId() != null) {
            return null;
        }

        return productRepository.save(product);
    }
}
