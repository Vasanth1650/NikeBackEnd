package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Charge;
import com.example.demo.service.ChargeService;

@RestController
@CrossOrigin
@RequestMapping("/charging")
public class ChargeController{
	
	@Autowired
	private ChargeService service;
	
	
	@PostMapping("/checkout")
	public Charge adder(@RequestBody Charge charge) throws Exception {
		return service.addCharge(charge);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<List<Charge>> findByUserid(@PathVariable int userid){
		return ResponseEntity.ok(service.getById(userid));
	}
		
	@DeleteMapping("/delete/{userid}")
	public List<Charge> checkoutDelete(@PathVariable int userid) {
		return service.deleteById(userid);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) throws Exception {
		service.deleteByIdTo(id);
	}
	
	
}