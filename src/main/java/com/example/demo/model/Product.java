package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_details")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String productname;
	
	private String productdescription;
	
	private String productprice;
	
	private String productsize;
	
	private String productspecification;
	
	private String comments;
	
	private String productimage1;
	
	private String productimage2;
	
	private String productimage3;
	
	private String gender;
	
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getProductsize() {
		return productsize;
	}

	public void setProductsize(String productsize) {
		this.productsize = productsize;
	}

	public String getProductspecification() {
		return productspecification;
	}

	public void setProductspecification(String productspecification) {
		this.productspecification = productspecification;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getProductimage1() {
		return productimage1;
	}

	public void setProductimage1(String productimage1) {
		this.productimage1 = productimage1;
	}

	public String getProductimage2() {
		return productimage2;
	}

	public void setProductimage2(String productimage2) {
		this.productimage2 = productimage2;
	}

	public String getProductimage3() {
		return productimage3;
	}

	public void setProductimage3(String productimage3) {
		this.productimage3 = productimage3;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", productdescription=" + productdescription
				+ ", productprice=" + productprice + ", productsize=" + productsize + ", productspecification="
				+ productspecification + ", comments=" + comments + ", productimage1=" + productimage1
				+ ", productimage2=" + productimage2 + ", productimage3=" + productimage3 + ", gender=" + gender
				+ ", category=" + category + "]";
	}

		

	

	

		
	
	
	
}
