package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SearchResult;
import com.example.demo.service.SearchService;

@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	@PostMapping("/add")
	public SearchResult add(@RequestBody SearchResult search) {
		return service.addSearch(search);
	}
	
	

}
