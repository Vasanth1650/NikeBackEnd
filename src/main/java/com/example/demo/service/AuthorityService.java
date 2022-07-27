package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AuthRepository;
import com.example.demo.model.Authority;

@Service
public class AuthorityService {
	
	
	@Autowired
	private AuthRepository repository;
	
	
	public Authority getById(int id) {
		Optional<Authority>auth = repository.findById(id);
		Authority auths = null;
		if(auth.isPresent()) {
			auths = auth.get();
		}
		return (auths);
	}
}
