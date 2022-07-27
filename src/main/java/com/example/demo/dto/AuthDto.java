package com.example.demo.dto;






public class AuthDto {

	private int userid;
	
	
	private int authoritiesid;
	
	//Getters and Setters
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public int getAuthoritiesid() {
		return authoritiesid;
	}
	
	public void setAuthoritiesid(int authoritiesid) {
		this.authoritiesid = authoritiesid;
	}
	
	
	public AuthDto(int userid, int authoritiesid) {
		super();
		this.userid = userid;
		this.authoritiesid = authoritiesid;
	}
	
	//Super Constructor To Refer To The Base Class
	public  AuthDto() {
		super();
	}
	
	//To String Helps To Get A String Object Representing The Value In Number Object 
	@Override
	public String toString() {
		return "Auth [userid=" + userid + ", authoritiesid=" + authoritiesid + "]";
	}
	
	
		
	
	
	
	
}