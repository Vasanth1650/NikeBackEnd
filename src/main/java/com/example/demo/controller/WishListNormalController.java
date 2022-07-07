package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.WishListNormal;
import com.example.demo.service.WishListNormalService;

@RestController
@CrossOrigin
@RequestMapping("/normalwishing")
public class WishListNormalController {
	
	@Autowired
	public WishListNormalService service;
	
	@PostMapping("/addwishlist")
	public WishListNormal adder(@RequestBody WishListNormal wish) throws Exception {
		return service.adding(wish);
	}
	
	@GetMapping("/{id}")
	public WishListNormal findByIds(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/username/{username}")
	public List<WishListNormal> findByUser(@PathVariable String name){
		return service.getByUsername(name);
	}
	
	@GetMapping("/userid/{userid}")
	public List<WishListNormal> findByUserid(@PathVariable String userid){
		return service.getByUserid(userid);
	}
	
	@GetMapping("/productid/{productid}")
	public List<WishListNormal> findByProductid(@PathVariable String productid) {
		return service.getByProductid(productid);
	}
	
	@DeleteMapping("/{id}")
	public String deleting(@PathVariable int id) {
		service.deleteById(id);
		return "Removed From The WishList";
	}

}
