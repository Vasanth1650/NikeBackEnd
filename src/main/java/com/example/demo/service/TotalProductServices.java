/**
 * TotalProductService Class Is Defined For Normal Products Without Higher Information Are Controlled Under This Class
 * **/

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TotalProductRepository;
import com.example.demo.dto.TotalProductsDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.TotalProductMapper;
import com.example.demo.model.TotalProducts;

@Service
public class TotalProductServices {
	
	//Repository
	@Autowired
	private TotalProductRepository repository;
	
	
	@Autowired
	private TotalProductMapper mapper;
	
	
	//Logger
	Logger logger = LogManager.getLogger(TotalProductServices.class);
	
	
	//FindAllProducts In Normal List
	public List<TotalProductsDto> getProducts(){
		//Logger Stores The Info OF All Products
		logger.info("Viewing All products");
		List<TotalProducts>products =  repository.findAll();
		return mapper.toTotalProductsDtos(products);
	}
	
	//GetProductByName
	public List<TotalProductsDto> getProductname(String productname){
		//Returns Product Under A Name
		List<TotalProducts>list =  repository.findByProductname(productname);
		try {
			if(list==null) {
				//If List Empty
				logger.error("No Items Found In TotalProducts Under Name");
				throw new ResourceNotFoundException("Catch ME");
			}else {
				//If List Contains The Product
				logger.info("Getting Product By Name :");
			}
		}catch(Exception e) {
			//Catches The Exception
			throw new ResourceNotFoundException("Error Occured In Total Get ProductName"+productname);
		}
		//Returns The List 
		return mapper.toTotalProductsDtos(list);
	}
	
	//Getting Products Under A Category 1 
	public List<TotalProductsDto> getCategory1(String category1){
		List<TotalProducts>list = repository.findByCategory1(category1);
		try {
			if(list==null) {
				//if List Empty
				logger.error("In Normal Product List The Catgory Is Unable To Find :");
				throw new ResourceNotFoundException("Catch ME");
			}else {
				//If List Found Under The Category1
				logger.info("Products Searching Under A Category 1 ...");
			}
		}catch(Exception e) {
			//Catches The Exception
			throw new ResourceNotFoundException("NO Products Found Under Category1"+category1);
		}
		//Returns The List
		return mapper.toTotalProductsDtos(list);
	}
	
	//The Product May be In Certain Collection So Getting Them Under The Collection
	public List<TotalProductsDto> getCollection(String collection){
		//Gets Info Picking Under The COllection
		logger.info("Products Found Under The Collection ");
		List<TotalProducts>product = repository.findByCollection(collection);
		return mapper.toTotalProductsDtos(product);
	}
	
	//Used to Find Gender Collection
	public List<TotalProductsDto> getGender(String gender){
		//Returns The Gender Category List
		logger.info("The Products Finding under The Gender Category ");
		List<TotalProducts>product = repository.findByGender(gender);
		return mapper.toTotalProductsDtos(product);
	}
	
	//Used To Add New Products Under The Normal List
	public TotalProductsDto addProduct(TotalProductsDto total) {
		//GEts The Details Of NEw Products
		logger.warn("New Products Entering Into The Database Normal ");
		TotalProducts product = mapper.toTotalProducts(total);
		product = repository.save(product);
		return mapper.toTotalProductsDto(product);
	}
	
	public TotalProductsDto getProductbyId(int id) {
		Optional<TotalProducts> products = repository.findById(id);
		TotalProducts list = null;
		if(products.isPresent()) {
			list = (products.get());
		}
		return mapper.toTotalProductsDto(list);
	}
	
	public void deletebyId(int id) {
		repository.deleteById(id);
	}
	
	public TotalProductsDto updateProducts(TotalProductsDto product) {
		if(getProductbyId(product.getId())==null) {
			return null;
		}
		TotalProducts products = repository.save(product);
		return mapper.toTotalProductsDto(products);
	}

}
