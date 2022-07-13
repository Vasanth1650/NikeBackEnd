package com.example.demo.response;
/**
 * After Authentication The Token Contains This UserInfo Entity Information Where User Is Allowed To Access This Particular
 * Data
 * @author Vasanth
 *
 */
public class UserInfo {
	
	private long id;
	private String email;
	private String phonenumber;
	private String username;
	private String address;
	private String state;
	private String city;
	private String subscription;
	private Object roles;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}
	
	

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Object getRoles() {
		return roles;
	}

	public void setRoles(Object roles) {
		this.roles = roles;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}