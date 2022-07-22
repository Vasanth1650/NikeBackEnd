/**
 * WishList Class Used To Store The ProductId And Userid Particular Liked Order Once To Buy The Product Later
 * Warning : Handle The Iterator Carefully The System May Collapse
 * @author Vasanth
 * **/




package com.example.demo.service;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WishListRepository;
import com.example.demo.dto.WishListDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.WishListMapper;
import com.example.demo.model.WishList;

@Service
public class WishListService {

	//Logger
	Logger logger = LogManager.getLogger(WishListService.class);

	//Repository
	@Autowired
	private WishListRepository repository;
	
	@Autowired
	private WishListMapper mapper;

	//Adding New WishList In Adding
	public WishListDto adding(WishListDto wish){
		//Creating a Null Variable To Store Value Later After Checking
		WishList wishing = mapper.toWishList(wish);
		//Creating A Variable To Count The Particular ProductId Under A Particular Userid
		int count = 0;
		//List Used To Get Information Of Productid Which IS Going To Store With Userid
		logger.info("Entering Wishlist Gateway.....");
		List<WishList> productid = repository.findByProductid(wish.getProductid());
		//Iterator To Run Through The productid
		Iterator<WishList> iterator = productid.iterator();
		//Iterator Loops Checks One By One In The ProductId List Wheather The UserId Present In The Particular Product List
		logger.info("Entering The Iterator Gateway");
		while(iterator.hasNext()) {
			WishList list = iterator.next();
			if(list.getUserid().equals(wish.getUserid())) {
				//Counts The Userid Present In The Particular Ordered List
				logger.info("Error May Occur Wait For The Checking...");
				count++;
			}
		}
		//Checks After Iterator Gateway
		if(count>=1) {
			logger.error("The Item Already Exists In Wishlist");
			throw new ResourceNotFoundException("Already Exists"+wish);
		}else {
			logger.info("New Item Added In WishList");
			wishing = repository.save(wishing);
		}
		//Return wishing
		return mapper.toWishListDto(wishing);
	}

	//Getting By Id
	public WishListDto getById(int id) {
		logger.info("Getting Particular Id In WIshList");
		Optional<WishList> wish = repository.findById(id);
		WishList list = null;
		if(wish.isPresent()) {
			list = wish.get();
		}
		return mapper.toWishListDto(list);
	}

	//Getting By Userid
	public List<WishListDto> getByUserid(String userid) {
		logger.info("Getting Particular List By Userid In Wish List");
		List<WishList>list = repository.findByUserid(userid);
		return mapper.toUserDtos(list);
	}

	//Getting List Under Username
	public List<WishListDto> getByUsername(String username) {
		logger.info("Getting Username Under WishList");
		List<WishList>wish = repository.findByUsername(username);
		return mapper.toUserDtos(wish);
	}

	//Getting Product By Id In WishList
	public List<WishListDto> getByProductid(String productid) {
		logger.info("Getting Product Id Under Wish List");
		List<WishList>list = repository.findByProductid(productid);
		return mapper.toUserDtos(list);
	}

	//Deleting The Particular Wishlist Data In Wishlist
	public void deleteById(int id) {
		logger.warn("Deleteing From WishList");
		repository.deleteById(id);
	}

}
