package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.entities.Product;

public interface ProductService {
	public Page<Product> getAllProducts(int page);
    public Product createProduct(Product product,int categoryId);
    public Product getProductById(int id);
	public Product updateProduct(int id, Product product,int categoryId);
	public String deleteProductById(int id);

}
