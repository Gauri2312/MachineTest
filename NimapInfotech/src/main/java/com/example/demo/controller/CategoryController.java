package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
	@Autowired
	public CategoryService categoryService;
	
	@GetMapping("/getAllCategories")
	public Page<Category> getAllCategories(@RequestParam(defaultValue="0") int page){
		return categoryService.getAllCategories(page);
	}
	
	@PostMapping("/createCategory")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}
	
	@GetMapping("/getCategoryById/{cid}")
	public Category getCategoryById(@PathVariable("cid") int id) {
		return categoryService.getCategoryById(id);
	}
	
	@PutMapping("/updateCategory/{cid}")
	public Category updateCategory(@PathVariable("cid") int id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}
	
	@DeleteMapping("/deleteCategoryById/{cid}")
	public String deleteCategoryById(@PathVariable("cid") int id) {
		  categoryService.deleteCategoryById(id);
		  return "Category deleted.";
	}
	
}
