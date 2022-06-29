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
		User local = this.userdetailrepository.findByUsername(user.getUsername());
		try {
		if(local!=null) {
			//Checks And Throws Runtime Exception If User Already Exists And Logs
			logger.error("User Already Present With Username");
			System.out.println("User Already Present");
			throw new RuntimeException("Error Occured");
			
		}else {
			//If User Didn't Exists The Data Will Be Stored 
			logger.info("User Data Successfully Stored");
			local = userdetailrepository.save(user);
		}
		}catch(Exception e) {
			//Catch Exception If Error Ocuured
			throw new Exception("Error Has Been Ocuured In Signing In");
		}
		return local;
	}
	
	
	//To Get Particular User By Id
	public User getById(int id) {
		Optional<User> option = userdetailrepository.findById(id);
		return (option.get());
	}

}
	