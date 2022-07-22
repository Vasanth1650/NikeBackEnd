/**
 * CustomUserService Class Acts For getting User Information And Storing New Information Of New User
 * Where UserDetailsService Consists Of A loadUserByUsername Which Is Overrided Here
 * @author Vasanth
 * */

package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDetailsRepository;
import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;


@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	UserDetailsRepository userdetailrepository;
	
	@Autowired
	private UserMapper mapper;
	
	Logger logger = LogManager.getLogger(CustomUserService.class);
	
	//To Get Particular Username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userdetailrepository.findByUsername(username);
		
		if(null==user) {
			throw new UsernameNotFoundException("User Not Found With username"+username);
		}
		return user;
		
	}
	
	//findbyUsername Method
	public UserDto getByUsername(String username){
		//checks if any username exists
		User user = userdetailrepository.findByUsername(username);
		try {
			if(user==null) {
				//if not exists throws exception and log4j error
				logger.error("No User Found.... ");
				throw new ResourceNotFoundException("Catch me");
			}
			
		}catch(Exception e){
			//catches exception
			logger.error("The Username Is Not Present... ");
			throw new ResourceNotFoundException("The Username Is Not Present...");
		}
		return mapper.toUserDto(user);
	}
	
	
	//To Add New User
	public UserDto addUser(UserDto user)  {
		//getting values locally if username is foundby
		User local = mapper.toUser(user);
		User local1 = this.userdetailrepository.findByUsername(user.getUsername());
		try {
			if(local1 != null) {
				//logger throws error message where the information of the user already exists and exception
				logger.error("User Already Exists");
				throw new ResourceNotFoundException("Catch me");
			}else {
				//if not any saves the data
				logger.info("User Not Exists So Adding Them");
				//and saves in local variable
				local = userdetailrepository.save(local);
			}
		}
		catch(Exception e) {
			//catches any exception occurs
			throw new ResourceNotFoundException("User Already Exists");
		}
		return mapper.toUserDto(local);
	}
	
	
	//To Get Particular User By Id
	public UserDto getById(int id) {
		logger.warn("Getting Info Of The User :");
		Optional<User> option = userdetailrepository.findById(id);
		User user = null;
		if(!option.isPresent()) {
			throw new ResourceNotFoundException("User Id Not Present");
		}
		user = option.get();
		return mapper.toUserDto(user);
	}
	
	//To Get All Users
	public List<UserDto> getUsers(){
		//Data breach may occur user data may be stolen
		logger.fatal("Values Are Getting For Security");
		List<User>list =  userdetailrepository.findAll();
		return mapper.toUserDtos(list);
	}
	
	//Update Method To Update User Information
	public UserDto updateUser(UserDto user) {
		if(getById(user.getId())==null) {
			logger.error("Id Not Found");
			return null;
		}
		User list = userdetailrepository.save(user);
		return mapper.toUserDto(list);
	}
	
	//updateUser adder
	public UserDto updateAdder(UserDto user) {
		User list = mapper.toUser(user);
		list = userdetailrepository.save(list);
		return mapper.toUserDto(list);
	}

}
	