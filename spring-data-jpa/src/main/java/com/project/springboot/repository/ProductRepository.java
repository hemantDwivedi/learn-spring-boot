package com.project.springboot.repository;

import com.project.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Find product by name.
     *
     * @param name the name
     * @return the product
     */
    Product findByName(String name);

    Optional<Product> findById(Long id);

    /**
     * Find product by name and description.
     *
     * @param name        the name
     * @param description the description
     * @return the product
     */
    Product findByNameAndDescription(String name, String description);

    /**
     * Find product by name or description.
     *
     * @param name        the name
     * @param description the description
     * @return the product
     */
    Product findByNameOrDescription(String name, String description);

    /**
     * Find product with distinct name.
     *
     * @param name the name
     * @return the product
     */
    Product findDistinctByName(String name);

    /**
     * Find product by price greater than the given the price.
     *
     * @param price the price
     * @return product list
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Find products by price less than the given price.
     *
     * @param price the price
     * @return product list
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Find product by name containing SQL like condition.
     *
     * @param name
     * @return product list
     */
    List<Product> findByNameContaining(String name);

    /**
     * Find product by name like SQL 'like' condition
     *
     * @param name
     * @return the list
     */
    List<Product> findByNameLike(String name);

    /**
     * Find by price between the start price and end price
     *
     * @param startPrice the start price
     * @param endPrice   the end price
     * @return the list
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * Find by date created between start date and end date
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the list
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * Find products by multiple name.
     *
     * @param names the names
     * @return product list
     */
    List<Product> findByNameIn(List<String> names);

    /**
     * Find products by name in ascending order with limit 2 like SQL limit condition
     *
     * @return product list
     */
    List<Product> findFirst2ByOrderByNameAsc();

    /**
     * Find 3 products by price in descending order like SQL limit condition
     *
     *
     * @return product list
     */
    List<Product> findTop3ByOrderByPriceDesc();
}
