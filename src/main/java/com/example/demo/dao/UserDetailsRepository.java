package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;



@Repository
public interface UserDetailsRepository extends JpaRepository<User,Integer>{
	 User findByUsername(String username);

	 Object getById(long id);

	User save(UserDto user);

	 

}
