package com.example.spring.resources;

import com.example.spring.model.entities.Category;
import com.example.spring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> findAllCategories() {
        List<Category> categoryList = categoryService.findAllCategories();

        return ResponseEntity.ok().body(categoryList);
    }
    @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> findCategoryById(@PathVariable(value = "categoryId") long categoryId) {
        Category category = categoryService.findCategoryById(categoryId);

        return ResponseEntity.ok().body(category);
    }
}
