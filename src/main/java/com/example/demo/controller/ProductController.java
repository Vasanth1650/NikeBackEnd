package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
			
	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping("/allproducts")
	public List<Product> getAllProducts() throws Exception{
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) throws Exception{
		return service.getProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteByProductId(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@GetMapping("/gender/{gender}")
	public List<Product> findByGender(@PathVariable String gender){
		return service.getByGender(gender);
	}
	
}
