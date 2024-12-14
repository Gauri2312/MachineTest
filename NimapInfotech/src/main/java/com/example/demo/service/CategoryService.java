package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Category;

public interface CategoryService {
	public Page <Category> getAllCategories(int page);
	public Category createCategory(Category category);
	public Category getCategoryById(int id);
	public Category updateCategory(int id, Category category);
	public String deleteCategoryById(int id);

}
