package com.example.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WishListNormalRepository;
import com.example.demo.model.WishListNormal;

@Service
public class WishListNormalService {
	
	@Autowired
	public WishListNormalRepository repository;
	
	//Logger
	Logger logger = LogManager.getLogger(WishListNormalService.class);
	
	
	//Adding New WishList In Adding
		public WishListNormal adding(WishListNormal wish) throws Exception{
			//Creating a Null Variable To Store Value Later After Checking
			WishListNormal wishing = null;
			//Creating A Variable To Count The Particular ProductId Under A Particular Userid
			int count = 0;
			//List Used To Get Information Of Productid Which IS Going To Store With Userid
			logger.info("Entering Wishlist Gateway.....",wish);
			List<WishListNormal> productid = repository.findByProductid(wish.getProductid());
			//Iterator To Run Through The productid
			Iterator<WishListNormal> iterator = productid.iterator();
			//Iterator Loops Checks One By One In The ProductId List Wheather The UserId Present In The Particular Product List
			logger.info("Entering The Iterator Gateway");
			while(iterator.hasNext()) {
				WishListNormal list = iterator.next();
				if(list.getUserid().equals(wish.getUserid())) {
					//Counts The Userid Present In The Particular Ordered List
					logger.info("Error May Occur Wait For The Checking...");
					count++;
				}
			}
			//Checks After Iterator Gateway
			if(count>=1) {
				logger.error("The Item Already Exists In Wishlist");
				throw new Exception("Already Exists");
			}else {
				logger.info("New Item Added In WishList");
				wishing = repository.save(wish);
			}
			//Return wishing
			return wishing;
		}

		//Getting By Id
		public WishListNormal getById(int id) {
			logger.info("Getting Particular Id In WIshList",id);
			Optional<WishListNormal> wish = repository.findById(id);
			return (wish.get());
		}

		//Getting By Userid
		public List<WishListNormal> getByUserid(String userid) {
			logger.info("Getting Particular List By Userid In Wish List");
			return repository.findByUserid(userid);
		}

		//Getting List Under Username
		public List<WishListNormal> getByUsername(String username) {
			logger.info("Getting Username Under WishList",username);
			return repository.findByUsername(username);
		}

		//Getting Product By Id In WishList
		public List<WishListNormal> getByProductid(String productid) {
			logger.info("Getting Product Id Under Wish List");
			return repository.findByProductid(productid);
		}

		//Deleting The Particular Wishlist Data In Wishlist
		public void deleteById(int id) {
			logger.warn("Deleteing From WishList",id);
			repository.deleteById(id);
		}


}
