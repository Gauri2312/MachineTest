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

import com.example.demo.entities.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	public ProductService productService;
	
	@GetMapping("/getAllProducts")
	public Page<Product> getAllProducts(@RequestParam(defaultValue="0")int page){
		return productService.getAllProducts(page);
	}
	
	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product, product.getCategoryId());
    }
	
	@GetMapping("/getProductById/{pid}")
	public Product getProductById(@PathVariable("pid") int id) {
		return productService.getProductById(id);
	}
	
	@PutMapping("/updateProduct/{pid}")
	public Product updateProduct(@PathVariable("pid") int id,@RequestBody Product product) {
		return productService.updateProduct( id, product, product.getCategoryId());
	}

	@DeleteMapping("/deleteProductById/{pid}")
    public String deleteProductById(@PathVariable("pid") int id) {
		 productService.deleteProductById(id);
		 return "Product deleted.";
	}
	
}
