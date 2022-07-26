package com.example.demo.controller;

import java.security.Principal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.JwtTokenHelper;
import com.example.demo.model.Authority;
import com.example.demo.model.User;
import com.example.demo.response.AuthenticationRequest;
import com.example.demo.response.LoginResponse;
import com.example.demo.response.UserInfo;
import com.example.demo.service.AuthorityService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthenticationController {
	

	Logger logger = LogManager.getLogger(AuthenticationController.class);
	
	    

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	JwtTokenHelper jWTTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthorityService service;

	@PostMapping("/auth/login")
	public ResponseEntity<LoginResponse> login(@RequestBody AuthenticationRequest authenticationRequest)  {

		final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		User user=(User)authentication.getPrincipal();
		String jwtToken=jWTTokenHelper.generateToken(user.getUsername());
		
		LoginResponse response=new LoginResponse();
		response.setToken(jwtToken);
		return ResponseEntity.ok(response);
	}
	
	
	
	@GetMapping("/auth/userinfo")
	public ResponseEntity<UserInfo> getUserInfo(Principal user){
		User userObj=(User) userDetailsService.loadUserByUsername(user.getName());
		Authority auth = service.getById(userObj.getId());
		
		UserInfo userInfo=new UserInfo();
		userInfo.setId(userObj.getId());
		userInfo.setUsername(userObj.getUsername());
		userInfo.setEmail(userObj.getEmail());
		userInfo.setPhonenumber(userObj.getPhonenumber());
		userInfo.setRoles(userObj.getAuthorities().toArray());
		userInfo.setRoleCode(auth.getRoleCode());
		userInfo.setAddress(userObj.getAddress());
		userInfo.setCity(userObj.getCity());
		userInfo.setSubscription(userObj.getSubscription());
		userInfo.setState(userObj.getState());
		return ResponseEntity.ok(userInfo);	
		
	}
}