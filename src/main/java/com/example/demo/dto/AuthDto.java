package com.example.demo.dto;






public class AuthDto {

	private int user_id;
	
	
	private int authorities_id;
	
	//Getters and Setters
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getAuthorities_id() {
		return authorities_id;
	}
	
	public void setAuthorities_id(int authorities_id) {
		this.authorities_id = authorities_id;
	}
	
	
	public AuthDto(int user_id, int authorities_id) {
		super();
		this.user_id = user_id;
		this.authorities_id = authorities_id;
	}
	
	//Super Constructor To Refer To The Base Class
	public  AuthDto() {
		super();
	}
	
	//To String Helps To Get A String Object Representing The Value In Number Object 
	@Override
	public String toString() {
		return "Auth [user_id=" + user_id + ", authorities_id=" + authorities_id + "]";
	}
	
	
		
	
	
	
	
}