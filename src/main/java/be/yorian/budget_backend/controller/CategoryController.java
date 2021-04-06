package be.yorian.budget_backend.controller;

import java.util.List;
import java.util.Optional;

import be.yorian.budget_backend.entity.Category;
import org.springframework.http.ResponseEntity;

public interface CategoryController {

    public List<Category> getCategories();
    public Optional<Category> getCategory(long id);
    public ResponseEntity<Void> saveCategory(Category category);
    public Category updateCategory(long category_id, Category category);
    public void deleteCategory(long category_id);
        
    
}
