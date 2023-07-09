package com.example.spring.services;

import com.example.spring.model.entities.Product;
import com.example.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAllProducts() {
        List<Product> productList = productRepository.findAll();

        if (!productList.isEmpty()) {
            for (Product p : productList) {
                p.getCategories().addAll(productRepository.findCategoriesByIdProduct(p.getId()));
            }
        }

        return productRepository.findAll();
    }

    public Product findProductById(long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            return null;
        }

        optionalProduct.get().getCategories().addAll(productRepository.findCategoriesByIdProduct(productId));

        return optionalProduct.get();
    }
}
