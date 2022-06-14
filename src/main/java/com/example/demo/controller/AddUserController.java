package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.CustomUserService;

@RequestMapping("/addnew")
@RestController
@CrossOrigin
public class AddUserController {
	
	@Autowired
	public CustomUserService customservice;
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return customservice.addUser(user);
	}	

}
