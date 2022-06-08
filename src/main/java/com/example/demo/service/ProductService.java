package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;

@Service
public class ProductService {
	
	Logger logger = LogManager.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository repository;
	
	
	public List<Product>getProducts(){
		List<Product> list = repository.findAll();
		if(list.isEmpty()) {
			logger.error("No Data Present");
		}
		return list;
	}
	
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
	public Product getProductById(int id) {
		Optional<Product>product = repository.findById(id);
		return (product.get());
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	public Product updateProduct(int id,Product product) {
		if(getProductById(product.getId())==null) {
			return null;
		}
		return repository.save(product);
	}
	
	
	
}
