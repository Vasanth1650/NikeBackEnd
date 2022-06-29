/**
 * Charge Class Which Acts As The Checkout Component In UI And Helps User To Purchase Many Items As He/She Want
 * This Will Act As Cart Which Used To Display In The Checkout Billing
 * @author Vasanth
 * **/
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "charge")
public class Charge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int userid;
	
	private String username;
	
	private String productname;
	
	private String image1;
	
	private int price;
	
	private String size;
	
	
	//Getters And Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	//Super Constructor Which Helps To Refer The Base Class
	public Charge() {
		super();
	}

	
	//ToString To Refer To Particular Entity
	@Override
	public String toString() {
		return "Charge [id=" + id + ", userid=" + userid + ", username=" + username + ", productname=" + productname
				+ ", image1=" + image1 + ", price=" + price + ", size=" + size + "]";
	}

	
	
	
	
	

}
