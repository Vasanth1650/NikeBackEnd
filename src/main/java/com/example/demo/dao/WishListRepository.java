package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Integer>{

	List<WishList> findByUserid(String userid);

	List<WishList> findByProductid(String productid);

	List<WishList> findByUsername(String username);

	WishList save(HashMap<String, String> map);

	List<WishList> findByProductid(WishList wishList);
	


}
