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
import com.example.demo.dto.TotalProductsDto;
import com.example.demo.service.TotalProductServices;

@RestController
@CrossOrigin
@RequestMapping("/totalproducts")
public class TotalProductsController {
	
	@Autowired
	private TotalProductServices service;
	
	
	@GetMapping("/allproducts")
	public List<TotalProductsDto>allProducts(){
		return service.getProducts();
	}
	
	@PostMapping("/addproducts")
	public TotalProductsDto adding(@RequestBody TotalProductsDto particular) {
		return service.addProduct(particular);
	}
	
	@GetMapping("/{id}")
	public TotalProductsDto productsbyID(@PathVariable int id) {
		return service.getProductbyId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleted(@PathVariable int id) {
		service.deletebyId(id);
		return "Deleted Success";
	}
	
	@GetMapping("/name/{productname}")
	public ResponseEntity<List<TotalProductsDto>> findByProductname(@PathVariable String productname){
		return ResponseEntity.ok(service.getProductname(productname));
	}
	
	@GetMapping("/gender/{gender}")
	public ResponseEntity<List<TotalProductsDto>> findByGender(@PathVariable String gender){
		return ResponseEntity.ok(service.getGender(gender));
	}
	
	@GetMapping("/collection/{collection}")
	public ResponseEntity<List<TotalProductsDto>> findByCategory(@PathVariable String collection){
		return ResponseEntity.ok(service.getCollection(collection));
	}
	
	@GetMapping("/category/{category1}")
	public ResponseEntity<List<TotalProductsDto>> findByCatesgory(@PathVariable String category1){
		return ResponseEntity.ok(service.getCategory1(category1));
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<TotalProductsDto> updateProduct(@PathVariable int id,@RequestBody TotalProductsDto product) {
		TotalProductsDto products = service.getProductbyId(id);
		products.setProductname(product.getProductname());
		products.setProductdescription(product.getProductdescription());
		products.setPrice(product.getPrice());
		products.setSize1(product.getSize1());
		products.setSize2(product.getSize2());
		products.setSize3(product.getSize3());
		products.setSize4(product.getSize4());
		products.setSize5(product.getSize5());
		products.setProductspecification1(product.getProductspecification1());
		products.setProductspecification2(product.getProductspecification2());
		products.setProductspecification3(product.getProductspecification3());
		products.setProductspecification4(product.getProductspecification4());
		products.setProductspecification5(product.getProductspecification5());
		products.setImage1(product.getImage1());
		products.setImage2(product.getImage2());
		products.setImage3(product.getImage3());
		products.setImage4(product.getImage4());
		products.setImage5(product.getImage5());
		products.setImage6(product.getImage6());
		products.setImage7(product.getImage7());
		products.setImage8(product.getImage8());
		products.setImage9(product.getImage9());
		products.setImage10(product.getImage10());
		products.setImage11(product.getImage11());
		products.setImage12(product.getImage12());
		products.setGender(product.getGender());
		products.setDelivery(product.getDelivery());
		products.setCategory1(product.getCategory1());
		products.setCategory2(product.getCategory2());
		products.setCategory3(product.getCategory3());
		TotalProductsDto updated = service.addProduct(products);
		return ResponseEntity.ok(updated);
	}
	
	

}
