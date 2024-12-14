package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	public ProductRepository productrepository;
	@Autowired
	public CategoryRepository categoryrepository;

	@Override
	public Page<Product> getAllProducts(int page) {
		// TODO Auto-generated method stub
		return productrepository.findAll(PageRequest.of(page, 10));
	}

	@Override
	public Product createProduct(Product product,int categoryId) {
		// TODO Auto-generated method stub
		// Find the category by ID
        Category category = categoryrepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Associate the product with the category
        product.setCategory(category);

        // Save the product
        return productrepository.save(product);
    }
	
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productrepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
	}

	@Override
	public Product updateProduct(int id, Product product, int categoryId) {
		// TODO Auto-generated method stub
		// Fetch the existing product
        Product p1 = productrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Fetch the category
        Category category = categoryrepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Update fields
        p1.setPname(product.getPname());
        p1.setPprice(product.getPprice());
        p1.setPrating(product.getPrating());
        p1.setCategory(category);

        // Save updated product
        return productrepository.save(p1);
    }
	
	@Override
	public String deleteProductById(int id) {
		// TODO Auto-generated method stub
		productrepository.deleteById(id);
		return "Product deleted.";	
	}

}
