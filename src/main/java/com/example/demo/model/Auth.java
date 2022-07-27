/**
 * Entity Class For Storing Authority ID Which Is Mapped With The User Class
 * Entity user_id and authorities_id 
 * @Entity Refers This Is The Entity Class
 * @Table To The Particular Table For Operations
 * @author Vasanth
 */
 




package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

@Table(name="AUTH_USER_AUTHORITY")

public class Auth {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userid;
	
	@Column(name="authorities_id")
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
	
	
	public Auth(int userid, int authoritiesid) {
		super();
		this.userid = userid;
		this.authoritiesid = authoritiesid;
	}
	
	//no arg Constructor To Refer To The Base Class
	public Auth() {
		super();
	}
	
	//To String Helps To Get A String Object Representing The Value In Number Object 
	@Override
	public String toString() {
		return "Auth [userid=" + userid + ", authoritiesid=" + authoritiesid + "]";
	}
	
	
		
	
	
	
	
}
