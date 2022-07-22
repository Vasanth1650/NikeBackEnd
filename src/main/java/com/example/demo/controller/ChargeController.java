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
import com.example.demo.dto.ChargeDto;
import com.example.demo.service.ChargeService;

@RestController
@CrossOrigin
@RequestMapping("/charging")
public class ChargeController{
	
	@Autowired
	private ChargeService service;
	
	
	@PostMapping("/checkout")
	public ChargeDto adder(@RequestBody ChargeDto charge){
		return service.addCharge(charge);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<List<ChargeDto>> findByUserid(@PathVariable int userid){
		return ResponseEntity.ok(service.getById(userid));
	}
		
	@DeleteMapping("/delete/{userid}")
	public List<ChargeDto> checkoutDelete(@PathVariable int userid) {
		return service.deleteById(userid);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id){
		service.deleteByIdTo(id);
	}
	
	
}