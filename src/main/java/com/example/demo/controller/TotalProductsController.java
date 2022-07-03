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

import com.example.demo.model.TotalProducts;
import com.example.demo.service.TotalProductServices;

@RestController
@CrossOrigin
@RequestMapping("/totalproducts")
public class TotalProductsController {
	
	@Autowired
	private TotalProductServices service;
	
	
	@GetMapping("/allproducts")
	public List<TotalProducts>allProducts(){
		return service.getProducts();
	}
	
	@PostMapping("/addproducts")
	public TotalProducts adding(@RequestBody TotalProducts particular) {
		return service.addProduct(particular);
	}
	
	@GetMapping("/{id}")
	public TotalProducts productsbyID(@PathVariable int id) {
		return service.getProductbyId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleted(@PathVariable int id) {
		service.deletebyId(id);
		return "Deleted Success";
	}
	
	@GetMapping("/name/{productname}")
	public ResponseEntity<List<TotalProducts>> findByProductname(@PathVariable String productname) throws Exception {
		return ResponseEntity.ok(service.getProductname(productname));
	}
	
	@GetMapping("/gender/{gender}")
	public ResponseEntity<List<TotalProducts>> findByGender(@PathVariable String gender){
		return ResponseEntity.ok(service.getGender(gender));
	}
	
	@GetMapping("/collection/{collection}")
	public ResponseEntity<List<TotalProducts>> findByCategory(@PathVariable String collection){
		return ResponseEntity.ok(service.getCollection(collection));
	}
	
	@GetMapping("/category/{category1}")
	public ResponseEntity<List<TotalProducts>> findByCatesgory(@PathVariable String category1) throws Exception{
		return ResponseEntity.ok(service.getCategory1(category1));
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<TotalProducts> updateProduct(@PathVariable int id,@RequestBody TotalProducts product) {
		TotalProducts products = service.getProductbyId(id);
		products.setProductname(product.getProductname());
		products.setProductdescription(product.getProductdescription());
		products.setPrice(product.getPrice());
		products.setSize1(product.getSize1());
		products.setSize2(product.getSize2());
		products.setSize3(product.getSize3());
		products.setSize4(product.getSize4());
		products.setSize5(product.getSize5());
		products.setProductspecification1(product.getProductspecification1());
		products.setImage1(product.getImage1());
		products.setImage2(product.getImage2());
		products.setImage3(product.getImage3());
		products.setGender(product.getGender());
		products.setDelivery(product.getDelivery());
		products.setCategory1(product.getCategory1());
		products.setCategory2(product.getCategory2());
		products.setCategory3(product.getCategory3());
		TotalProducts updated = service.addProduct(products);
		return ResponseEntity.ok(updated);
	}
	
	

}
