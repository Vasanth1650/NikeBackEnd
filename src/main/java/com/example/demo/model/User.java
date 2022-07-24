/**
 * User Entity Class Acts As The Security For Login And Signing In With The Help Of AesEncryptor The User Detail Will Be
 * Stored In The Database With Encryption.
 * 
 * And User Class Implements UserDetails Where This UserDetails Repository Consists Of A Certain Method To Get Authorities
 * And getPassword() And Expiration Of Credential Which Is Provided By The SpringFrameWork Security Core 
 * @author Vasanth
 **/




package com.example.demo.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.dao.AesEncryptor;



@Table(name= "users" )
@Entity
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Convert(converter = AesEncryptor.class)
	private String username;
	
	@Convert(converter = AesEncryptor.class)
	private String password;
	
	@Convert(converter = AesEncryptor.class)
	private String email;
	
	@Convert(converter = AesEncryptor.class)
	private String phonenumber;
	

	private String address;
	

	private String state;
	

	private String city;
	
	private String subscription = "No Subscription";
	
	private boolean enabled=true;
	
	//Mapping To Define Authority Of The Particular User And Foreign Key For Storing Data
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "AUTH_USER_AUTHORITY", joinColumns = @JoinColumn(referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(referencedColumnName ="id"))
	private List<Authority> authorities;
	
	
	@OneToMany(targetEntity = Ordered.class,cascade = CascadeType.ALL)
	@JoinColumn(name="userid",referencedColumnName = "id")
	private List<Ordered> order;
	
	
	
	
	
	//Getters Ans Setters

	public List<Ordered> getOrder() {
		return order;
	}



	public void setOrder(List<Ordered> order) {
		this.order = order;
	}



	public User() {
		super();
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	
	

	public String getSubscription() {
		return subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
