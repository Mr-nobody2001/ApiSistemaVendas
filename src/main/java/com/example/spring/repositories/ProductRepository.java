package com.example.spring.repositories;

import com.example.spring.model.entities.Category;
import com.example.spring.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p.categories FROM Product AS p WHERE p.id = :idProduct")
    List<Category> findCategoriesByIdProduct(long idProduct);
}
