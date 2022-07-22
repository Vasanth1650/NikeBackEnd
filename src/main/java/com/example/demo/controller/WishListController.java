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

import com.example.demo.dto.WishListDto;
import com.example.demo.service.WishListService;

@RestController
@CrossOrigin
@RequestMapping("/wishlist")
public class WishListController {
	
	@Autowired
	private WishListService service;
	
	@PostMapping("/addwishlist")
	public WishListDto adder(@RequestBody WishListDto wish){
		return service.adding(wish);
	}
	
	@GetMapping("/{id}")
	public WishListDto findByIds(@PathVariable int id) {
		return service.getById(id);
	}
	
	@GetMapping("/username/{username}")
	public List<WishListDto> findByUser(@PathVariable String name){
		return service.getByUsername(name);
	}
	
	@GetMapping("/userid/{userid}")
	public List<WishListDto> findByUserid(@PathVariable String userid){
		return service.getByUserid(userid);
	}
	
	@GetMapping("/productid/{productid}")
	public List<WishListDto> findByProductid(@PathVariable String productid) {
		return service.getByProductid(productid);
	}
	
	@DeleteMapping("/{id}")
	public String deleting(@PathVariable int id) {
		service.deleteById(id);
		return "Removed From The WishList";
	}
	
	
	
	

}
