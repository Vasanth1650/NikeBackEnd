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
import com.example.demo.model.TotalProducts;

@Service
public class TotalProductServices {
	
	//Repository
	@Autowired
	private TotalProductRepository repository;
	
	
	//Logger
	Logger logger = LogManager.getLogger(TotalProductServices.class);
	
	
	//FindAllProducts In Normal List
	public List<TotalProducts> getProducts(){
		//Logger Stores The Info OF All Products
		logger.info("Viewing All products");
		return repository.findAll();
	}
	
	//GetProductByName
	public List<TotalProducts> getProductname(String productname) throws Exception{
		//Returns Product Under A Name
		List<TotalProducts>list =  repository.findByProductname(productname);
		try {
			if(list==null) {
				//If List Empty
				logger.error("No Items Found In TotalProducts Under Name"+productname);
				throw new RuntimeException("Catch ME");
			}else {
				//If List Contains The Product
				logger.info("Getting Product By Name :"+productname);
			}
		}catch(Exception e) {
			//Catches The Exception
			throw new RuntimeException("Error Occured In Total Get ProductName"+productname);
		}
		//Returns The List 
		return list;
	}
	
	//Getting Products Under A Category 1 
	public List<TotalProducts> getCategory1(String category1) throws Exception{
		List<TotalProducts>list = repository.findByCategory1(category1);
		try {
			if(list==null) {
				//if List Empty
				logger.error("In Normal Product List The Catgory Is Unable To Find :"+category1);
				throw new Exception("Catch ME");
			}else {
				//If List Found Under The Category1
				logger.info("Products Searching Under A Category 1 ..."+category1);
			}
		}catch(Exception e) {
			//Catches The Exception
			throw new Exception("NO Products Found Under Category1"+category1);
		}
		//Returns The List
		return list;
	}
	
	//The Product May be In Certain Collection So Getting Them Under The Collection
	public List<TotalProducts> getCollection(String collection){
		//Gets Info Picking Under The COllection
		logger.info("Products Found Under The Collection "+collection);
		return repository.findByCollection(collection);
	}
	
	//Used to Find Gender Collection
	public List<TotalProducts> getGender(String gender){
		//Returns The Gender Category List
		logger.info("The Products Finding under The Gender Category "+gender);
		return repository.findByGender(gender);
	}
	
	//Used To Add New Products Under The Normal List
	public TotalProducts addProduct(TotalProducts total) {
		//GEts The Details Of NEw Products
		logger.warn("New Products Entering Into The Database Normal "+total);
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
