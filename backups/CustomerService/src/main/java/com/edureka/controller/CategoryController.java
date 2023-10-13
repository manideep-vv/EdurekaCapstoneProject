package com.edureka.controller;

import com.edureka.model.Category;
import com.edureka.model.Product;
import com.edureka.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository repository;

    @GetMapping("/getAllCategories")
    public List<Category> getAll() {
        return repository.findAll();
    }

    @PostMapping("/createCategory")
    public List<Category> saveCategory(@RequestBody Category category) {
        System.out.println("saved category as " + category);
        repository.save(category);
        return repository.findAll();
    }

    @PutMapping("/updateCategory")
    public List<Category> updateCategory(@RequestBody Category category) {
        Optional<Category> existingcategory = repository.findById(category.getId());
        if (existingcategory.isPresent()) {
            System.out.println("updating category as " + category);
            existingcategory.get().setName(category.getName());
        } else {
            repository.save(category);
        }
        return repository.findAll();
    }

    @DeleteMapping("/deleteCategory")
    public List<Category> deleteCategory(@RequestBody Category category) {
        System.out.println("delete category as " + category);
        return repository.findAll();

    }
}
