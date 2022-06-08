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
	public List<Product> getAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id){
		return service.getProductById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteByProductId(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProducts(@PathVariable int id,@RequestBody Product product) {
		Product products = service.getProductById(id);
		products.setProductname(product.getProductname());
		products.setProductdescription(product.getProductdescription());
		products.setProductprice(product.getProductprice());
		products.setProductsize(product.getProductsize());
		products.setProductspecification(product.getProductspecification());
		products.setComments(product.getComments());
		products.setProductimage1(product.getProductimage1());
		products.setProductimage2(product.getProductimage2());
		products.setProductimage3(product.getProductimage3());
		products.setGender(product.getGender());
		products.setCategory(product.getCategory());
		Product update = service.addProduct(products);
		return ResponseEntity.ok(update);
	}
}
