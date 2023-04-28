package com.projects.product.service;

import com.projects.product.entity.Product;

import java.util.List;

public interface ProductService {
 List<Product> searchProducts(String query);

 Product create(Product product);
}
