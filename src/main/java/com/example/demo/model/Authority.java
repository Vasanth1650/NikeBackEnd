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

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Table(name = "authority")
@Entity
public class Authority implements GrantedAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	public Authority() {
		super();
	}

}
