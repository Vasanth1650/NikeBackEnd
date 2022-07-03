/**
 * SearchService Under Construction Detects The Search Results And Stores And Gets The Max Search Results With This The
 * UI Can Be Interchanged
 * **/





package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SearchRepository;
import com.example.demo.model.SearchResult;

@Service
public class SearchService {
	
	//Repository
	@Autowired
	private SearchRepository repository;
	
	//Stores Search Results For Better Optimization
	public SearchResult addSearch(SearchResult search) {
		return repository.save(search);
	}

}
