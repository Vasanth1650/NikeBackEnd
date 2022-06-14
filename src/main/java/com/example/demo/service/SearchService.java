package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SearchRepository;
import com.example.demo.model.SearchResult;

@Service
public class SearchService {
	
	@Autowired
	private SearchRepository repository;
	
	
	public SearchResult addSearch(SearchResult search) {
		return repository.save(search);
	}

}
