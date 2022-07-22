package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.UserDto;
import com.example.demo.service.CustomUserService;

@RequestMapping("/addnew")
@RestController
@CrossOrigin
public class AddUserController {
	
	@Autowired
	public CustomUserService customservice;
	
	
	@PostMapping("/save")
	public UserDto saveUser(@RequestBody UserDto user){
		return customservice.addUser(user);
	}
	
	@GetMapping("/{id}")
	public UserDto getting(@PathVariable int id) {
		return customservice.getById(id);
	}
	
	@GetMapping("/findby/{username}")
	public UserDto getUserByName(@PathVariable String username){
		return customservice.getByUsername(username);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user,@PathVariable int id){
		UserDto users = customservice.getById(id);
		users.setUsername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setPhonenumber(user.getPhonenumber());
		users.setAddress(user.getAddress());
		users.setCity(user.getCity());
		users.setState(user.getState());
		users.setEmail(user.getEmail());
		users.setSubscription(user.getSubscription());
		UserDto update = customservice.updateAdder(users);
		return ResponseEntity.ok(update);
	}

}
