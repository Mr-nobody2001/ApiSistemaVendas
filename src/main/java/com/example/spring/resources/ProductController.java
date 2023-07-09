package com.example.spring.resources;

import com.example.spring.model.entities.Product;
import com.example.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> productList = productService.findAllProducts();

        return ResponseEntity.ok().body(productList);
    }

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> findProductById(@PathVariable(value = "productId") long productId) {
        Product product = productService.findProductById(productId);

        return ResponseEntity.ok().body(product);
    }
}
