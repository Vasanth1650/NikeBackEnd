package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WishListRepository;
import com.example.demo.model.WishList;

@Service
public class WishListService {
	
	@Autowired
	private WishListRepository repository;
	
	
	public WishList adding(WishList wish) {
		WishList wishing = null;
		List<WishList> local = repository.findByUsername(wish.getUserid());
		if((local==null)) {
			wishing = repository.save(wish);
			
		}else {
			System.out.println("Already Added In Wishlist");
		}
		return wishing;
	}
	
	public WishList getById(int id){
		Optional<WishList> wish = repository.findById(id); 
		return (wish.get());
	}
	
	public List<WishList> getByUserid(String userid){
		return repository.findByUserid(userid);
	}
	
	public List<WishList> getByUsername(String username){
		return repository.findByUsername(username);
	}
	
	public List<WishList> getByProductid(String productid){
		return repository.findByProductid(productid);
	}
	
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
