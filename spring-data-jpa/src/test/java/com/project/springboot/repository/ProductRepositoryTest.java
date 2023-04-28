package com.project.springboot.repository;

import com.project.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        // create new object of product entity
        Product product = new Product();
        product.setName("product new one");
        product.setDescription("this is product new one");
        product.setSku("100TT");
        product.setPrice(new BigDecimal(500));
        product.setActive(true);
        product.setImageUrl("img_100.jpeg");

        // save the product entity to database
         Product saveProduct = productRepository.save(product);

        // display product id and name
         System.out.println(saveProduct);
    }

    @Test
    void updateMethod(){
        // find entity by id
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        // update entity information
        product.setName("product new updated");
        product.setDescription("this is product updated description");
        // save the entity
         productRepository.save(product);
    }

    // Test case for find by id
    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        // System.out.println(product);
    }

    @Test
    void saveAllMethod(){
        // create new product entity
        // product 2
        Product product = new Product();
        product.setName("product new 4");
        product.setDescription("this is product new 4");
        product.setSku("112123D");
        product.setPrice(new BigDecimal(700));
        product.setActive(true);
        product.setImageUrl("img11.jpeg");

        // product 3
        Product product3 = new Product();
        product3.setName("product new 6");
        product3.setDescription("this is product new 6");
        product3.setSku("1652HH");
        product3.setPrice(new BigDecimal(366));
        product3.setActive(true);
        product3.setImageUrl("img_6.jpeg");

        // save all the product entity to database
        productRepository.saveAll(List.of(product, product3));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();

        products.forEach(
                product -> System.out.println(product.getName())
        );
    }

    @Test
    void deleteByIdTestMethod(){
        Long id = 8L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteTestMethod(){
        Long id = 7L;
        Product product = productRepository.findById(id).get();

        productRepository.delete(product);
    }

    @Test
    void deleteAllTestMethod(){
        // productRepository.deleteAll();
        Product product = productRepository.findById(11L).get();
        Product product1 = productRepository.findById(12L).get();
        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void countTestMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existEntityTestMethod(){
        System.out.println(productRepository.existsById(14L));
    }
}