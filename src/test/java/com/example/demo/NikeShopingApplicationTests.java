package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.UserDetailsRepository;
import com.example.demo.model.User;

@SpringBootTest
class NikeShopingApplicationTests {
	
	@Autowired 
	private UserDetailsRepository repo;

	@Test
	void contextLoads() {
	}
	
	
	
	
	 @Test
	    void retrieveData() {
	        User cardDetail = repo.findById(3).get();
	        System.out.println(cardDetail);
	    }
	

}
