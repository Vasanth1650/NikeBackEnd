package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.SearchService;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	
	
	

}
