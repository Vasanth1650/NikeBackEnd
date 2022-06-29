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
import com.example.demo.model.Product;

@Service
public class ProductService {
	
	//Logger
	Logger logger = LogManager.getLogger(ProductService.class);
	
	//ProdutRepository
	@Autowired
	private ProductRepository repository;
	
	//Getting All Products In The Product List
	public List<Product>getProducts() throws Exception{
		//Storing The Total Products In A Separate List
		List<Product> list = repository.findAll();
		//Checks Whether The List Is Empty
		try {
			if(list.isEmpty()) {
				//Checks And Throws Logger When The List Is Empty
				logger.error("The Popular List Is Empty");
				throw new Exception("Empty Product List");
			}
			else{
				//Return The Unempty List And Stores In Logger
				logger.info("returning The Values"+list);
			}
		}catch(Exception e) {
			//Catches The Exception From Try Catch
			throw new Exception("Exception Has Occured In getting Product List");
		}
		//Returns If Anything In List Even Though The List Empty
		return list;
	}
	
	//Adding New Products In The Popular List
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
	//Getting Particular Product By Id
	public Product getProductById(int id) throws Exception{
		Optional<Product>product = repository.findById(id);
		try {
			//Checks And Return Logs And Exception If Any
			if(product.isEmpty()) {
				logger.error("Unable To Find The Product");
				throw new Exception("The Product Doesnt Exists");
			}else {
				logger.info("The Product Is Getting");
			}
		}catch(Exception e) {
			//Catch Any Exception Occured In The Try Method
			throw new Exception("The Product Doesn't Exists");
		}
		//Returns The Product 
		return (product.get());
	}
	
	//Deleting The Product By Id
	public void deleteById(int id) {
		//log Stores The Deleting Information
		logger.warn("Some Information Are Getting Deleted In Product"+id);
		repository.deleteById(id);
	}
	
	//Product Has Different Category Picking Up By Gender
	public List<Product> getByGender(String gender){
		//Logger Gets The Particular Info
		logger.info("The Filter Is On For Gender");
		return repository.findByGender(gender);
	}
	
	//Update The Already Exists object
	public Product updateProduct(int id,Product product) throws Exception {
		if(getProductById(product.getId())==null) {
			return null;
		}
		return repository.save(product);
	}
	
	
	
}
