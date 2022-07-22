package com.example.demo.dto;

/**
 * Entity Class For Storing Authority Of The Particular User Whether The User Is Admin Or User
 * Which Is Mapped With The User Class
 * Entity roleCode and roleDescription
 * Class Implements GrantedAuthority Where This Class Helps To Set Authority For User The GrantedAuthority Is
 * Which Extends Serializable Which Convert The Data Into Byte 
 * @Entity Refers This Is The Entity Class
 * @Table To The Particular Table For Operations
 * @author Vasanth
 */





import org.springframework.security.core.GrantedAuthority;


public class AuthorityDto implements GrantedAuthority {

	private int id;

	private String roleCode;

	private String roleDescription;

	@Override
	public String getAuthority() {

		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	// Getters And Setters
	
	
	public AuthorityDto() {
		super();
	}

}
