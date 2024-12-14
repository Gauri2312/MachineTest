package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryrepository;

	@Override
	public Page<Category> getAllCategories(int page) {
		// TODO Auto-generated method stub
		return categoryrepository.findAll(PageRequest.of(page, 10));
	}

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryrepository.save(category);
	}

	@Override
	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryrepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
	}

	@Override
	public Category updateCategory(int id, Category category) {
		// TODO Auto-generated method stub
		Category c1 = categoryrepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
		c1.setCname(category.getCname());
		return categoryrepository.save(c1); 
	}
	
	@Override
	public String deleteCategoryById(int id) {
		// TODO Auto-generated method stub

			categoryrepository.deleteById(id);
			return "Category deleted.";

	  }
	}


