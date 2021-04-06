package be.yorian.budget_backend.controller.impl;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be.yorian.budget_backend.controller.CategoryController;
import be.yorian.budget_backend.entity.Category;
import be.yorian.budget_backend.service.CategoryService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryControllerImpl implements CategoryController{

	
    private CategoryService categoryService;

    public CategoryControllerImpl() {}

    @Autowired
    public CategoryControllerImpl(CategoryService categoryService) { 
    	this.categoryService = categoryService;
    }

    
    @Override
    @GetMapping("/categories")
    public List<Category> getCategories() {
    	return categoryService.getCategories();
    }

    @Override
    @GetMapping("/categories/{category_id}")
    public Optional<Category> getCategory(@PathVariable("category_id") long category_id) {
        return categoryService.getCategory(category_id);
    }

    @Override
    @PostMapping("/categories")
    public ResponseEntity<Void> saveCategory(@RequestBody Category category) {
        Category new_category = categoryService.saveCategory(category);

        return entityWithLocation(new_category.getId());
    }

    @Override
    @PostMapping("/categories-update/{category_id}")
    public Category updateCategory(@PathVariable("category_id")long category_id, @RequestBody Category category) {
        return categoryService.updateCategory(category_id, category);
    }
    
    @Override
    @DeleteMapping("categories-delete/{category_id}")
    public void deleteCategory(@PathVariable("category_id") long category_id) {
        categoryService.deleteCategory(category_id);
    }

    private ResponseEntity<Void> entityWithLocation(Object id) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{category_id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }
 }
