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
	
	@GetMapping("/productunder/{category1}")
	public List<Product> findByCategory1(@PathVariable String category1){
		return service.getByCategory(category1);
	}
	
	@GetMapping("/gender/{gender}")
	public List<Product> findByGender(@PathVariable String gender){
		return service.getByGender(gender);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product>editProduct(@RequestBody Product product,@PathVariable int id) throws Exception{
		Product products = service.getProductById(id);
		products.setProductname(product.getProductname());
		products.setProductdescription(product.getProductdescription());
		products.setProductprice(product.getProductprice());
		products.setSize1(product.getSize1());
		products.setSize2(product.getSize2());
		products.setSize3(product.getSize3());
		products.setSize3(product.getSize3());
		products.setSize4(product.getSize4());
		products.setSize5(product.getSize5());
		products.setProductspecification1(product.getProductspecification1());
		products.setProductspecification2(product.getProductspecification2());
		products.setProductspecification3(product.getProductspecification3());
		products.setProductspecification4(product.getProductspecification4());
		products.setProductspecification5(product.getProductspecification5());
		products.setProductimage1(product.getProductimage1());
		products.setProductimage2(product.getProductimage2());
		products.setProductimage3(product.getProductimage3());
		products.setProductimage4(product.getProductimage4());
		products.setProductimage5(product.getProductimage5());
		products.setProductimage6(product.getProductimage6());
		products.setProductimage7(product.getProductimage7());
		products.setProductimage8(product.getProductimage8());
		products.setProductimage9(product.getProductimage9());
		products.setProductimage10(product.getProductimage10());
		products.setProductimage11(product.getProductimage11());
		products.setProductimage12(product.getProductimage12());
		products.setGender(product.getGender());
		products.setCategory1(product.getCategory1());
		products.setCategory2(product.getCategory2());
		products.setCategory3(product.getCategory3());
		Product updated = service.addProduct(products);
		return ResponseEntity.ok(updated);
	}
	
	
}
