/**
 * ProductService For Main Entity For Popular Products Which Used To Store And Do Multiple Performance Then The Regular
 * Entity
 * @author Vasanth
 * **/



package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.dto.ProductDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.Product;

@Service
public class ProductService {
	
	//Logger
	Logger logger = LogManager.getLogger(ProductService.class);
	
	//ProdutRepository
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ProductMapper mapper;
	
	//Getting All Products In The Product List
	public List<ProductDto>getProducts(){
		//Storing The Total Products In A Separate List
		List<Product> list = repository.findAll();
		//Checks Whether The List Is Empty
		try {
			if(list.isEmpty()) {
				//Checks And Throws Logger When The List Is Empty
				logger.error("The Popular List Is Empty");
				throw new ResourceNotFoundException("Empty Product List");
			}
			else{
				//Return The Unempty List And Stores In Logger
				logger.info("returning The Values");
			}
		}catch(Exception e) {
			//Catches The Exception From Try Catch
			throw new ResourceNotFoundException("Exception Has Occured In getting Product List");
		}
		//Returns If Anything In List Even Though The List Empty
		return mapper.toProductsDtos(list);
	}
	
	//Adding New Products In The Popular List
	public ProductDto addProduct(ProductDto product) {
		Product products = mapper.toProduct(product);
		products = repository.save(products);
		return mapper.toProductDto(products);
	}
	
	//Getting Particular Product By Id
	public ProductDto getProductById(int id){
		Optional<Product>product = repository.findById(id);
		if(product.isEmpty()) {
			throw new ResourceNotFoundException("Nothing Present");
		}
		Product products = product.get();
		
		//Returns The Product 
		return mapper.toProductDto(products);
	}
	
	//Deleting The Product By Id
	public void deleteById(int id) {
		//log Stores The Deleting Information
		logger.warn("Some Information Are Getting Deleted In Product");
		repository.deleteById(id);
	}
	
	//Product Has Different Category Picking Up By Gender
	public List<ProductDto> getByGender(String gender){
		//Logger Gets The Particular Info
		logger.info("The Filter Is On For Gender");
		List<Product> product = repository.findByGender(gender); 
		return mapper.toProductsDtos(product);
	}
	
	//Product Picking Under The Category1
	public List<ProductDto> getByCategory(String category1){
		logger.info("Geeting Products Under The Category In ProductTable:");
		List<Product>product =  repository.findByCategory1(category1);
		return mapper.toProductsDtos(product);
	}
	
	//Update The Already Exists object
	public ProductDto updateProduct(ProductDto product){
		//Checks Whether The Product Exists
		if(getProductById(product.getId())==null) {
			return null;
		}
		//Returns After Update
		Product products = repository.save(product);
		return mapper.toProductDto(products);
	}
	
	
	
}
