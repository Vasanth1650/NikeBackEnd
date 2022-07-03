package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WishList;
import com.example.demo.model.WishListNormal;

@Repository
public interface WishListNormalRepository extends JpaRepository<WishListNormal,Integer>{
	
	
	List<WishListNormal> findByUserid(String userid);

	List<WishListNormal> findByProductid(String productid);

	List<WishListNormal> findByUsername(String username);

	WishListNormal save(HashMap<String, String> map);

	List<WishListNormal> findByProductid(WishList wishList);
	
	
}
