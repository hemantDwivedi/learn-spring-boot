package com.project.springboot.repository;

import com.project.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Query methods test.
 */
@SpringBootTest
class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    /**
     * Find by name test.
     */
    @Test
    void findByNameTest(){
        Product product = productRepository.findByName("product new two");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    /**
     * Find by id test.
     */
    @Test
    void findByIdTest(){
        Product product = productRepository.findById(11L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameAndDescriptionTest(){
        Product product = productRepository.findByNameAndDescription("product new two", "this is product new two");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByNameOrDescriptionTest(){
        Product product = productRepository.findByNameOrDescription("product new two", "this is product new two");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findDistinctByNameTest(){
        Product product = productRepository.findDistinctByName("product new two");
        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void findByPriceGreaterThanTest(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(200));
        products.forEach(
                product -> System.out.println(product.getName())
        );
    }

    @Test
    void findByPriceLessThanTest(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(400));
        products.forEach(
                product -> System.out.println(product.getName())
        );
    }

    @Test
    void findByNameContainingTest(){
        List<Product> products = productRepository.findByNameContaining("product");
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getDescription());
                }
        );
    }

    @Test
    void findByNameLikeTest(){
        List<Product> products = productRepository.findByNameLike("product");
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getDescription());
                }
        );
    }

    @Test
    void findByPriceBetween(){
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(100),
                new BigDecimal(300)
        );
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getDescription());
                }
        );
    }

    @Test
    void findByDateCreatedBetweenTest(){
        LocalDateTime startDate = LocalDateTime.of(2023, 4, 17, 9, 2, 15,430355);
        LocalDateTime endDate = LocalDateTime.of(2023, 4, 18, 9, 2, 15,430355);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getDescription());
                }
        );

    }

    @Test
    void findByNameInTest(){
        List<Product> products = productRepository.findByNameIn(List.of("product new two", "product new three"));
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getDescription());
                }
        );
    }

    @Test
    void findFirst2ByOrderByNameAscTest(){
        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getDescription());
                }
        );
    }

    @Test
    void findTop3ByOrderByPriceDesc(){
        List<Product> products = productRepository.findTop3ByOrderByPriceDesc();
        products.forEach(
                product -> {
                    System.out.println(product.getName());
                    System.out.println(product.getId());
                }
        );
    }
}
