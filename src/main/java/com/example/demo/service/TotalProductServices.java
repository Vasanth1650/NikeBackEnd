package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TotalProductRepository;
import com.example.demo.model.TotalProducts;

@Service
public class TotalProductServices {
	
	@Autowired
	private TotalProductRepository repository;
	
	
	public List<TotalProducts> getProducts(){
		return repository.findAll();
	}
	
	public List<TotalProducts> getProductname(String productname) {
		return repository.findByProductname(productname);
	}
	
	public List<TotalProducts> getCategory(String category){
		return repository.findByCategory(category);
	}
	
	public List<TotalProducts> getGender(String gender){
		return repository.findByGender(gender);
	}
	
	public TotalProducts addProduct(TotalProducts total) {
		return repository.save(total);
	}
	
	public TotalProducts getProductbyId(int id) {
		Optional<TotalProducts> products = repository.findById(id);
		return (products.get());
	}
	
	public void deletebyId(int id) {
		repository.deleteById(id);
	}
	
	public TotalProducts updateProducts(int id, TotalProducts product) {
		if(getProductbyId(product.getId())==null) {
			return null;
		}
		return repository.save(product);
	}

}
