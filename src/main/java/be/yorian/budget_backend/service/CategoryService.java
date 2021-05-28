package be.yorian.budget_backend.service;

import java.util.List;
import java.util.Optional;

import be.yorian.budget_backend.entity.Category;

public interface CategoryService {
	
	List<Category> getCategories();
	Optional<Category> getCategory(long category_id);
	Category saveCategory(Category category);
	Category updateCategory(Category category);
	void deleteCategory(long category_id);
	
}
