package com.projects.product.service.impl;

import com.projects.product.entity.Product;
import com.projects.product.repository.ProductRepository;
import com.projects.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Override
    public List<Product> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
