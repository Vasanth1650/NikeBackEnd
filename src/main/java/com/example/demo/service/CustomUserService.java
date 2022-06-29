/**
 * CustomUserService Class Acts For getting User Information And Storing New Information Of New User
 * Where UserDetailsService Consists Of A loadUserByUsername Which Is Overrided Here
 * @author Vasanth
 * */

package com.example.demo.service;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.demo.dao.UserDetailsRepository;
import com.example.demo.model.User;


@Service
public class CustomUserService implements UserDetailsService{
	
	@Autowired
	UserDetailsRepository userdetailrepository;
	
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
	public User getByUsername(String username) {
		try {
			if(username!=null) {
				logger.info("Checking.... "+username);
			}
		}catch(Exception e){
			logger.error("The Username Is Not Present... "+username);
			System.out.println("No Data Present For The UserName");
		}
		return userdetailrepository.findByUsername(username);
	}
	
	
	//To Add New User
	public User addUser(User user) throws Exception {
		User local = userdetailrepository.save(user);
		
		return local;
	}
	
	
	//To Get Particular User By Id
	public User getById(int id) {
		Optional<User> option = userdetailrepository.findById(id);
		return (option.get());
	}
	
	//Update Method To Update User Information
	public User updateUser(int id,User user) {
		if(getById(user.getId())==null) {
			logger.error("Id Not Found");
			return null;
		}
		return userdetailrepository.save(user);
	}

}
	