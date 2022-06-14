package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="totalproducts")
public class TotalProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String productname;
	
	private String productdescription;
	
	private String productspecification;
	
	private String size;
	
	private String gender;
	
	private String image1;
	
	private String image2;
	
	private String image3;
	
	private String category;
	
	private String price;
	
	private String delivery;

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

	public String getProductspecification() {
		return productspecification;
	}

	public void setProductspecification(String productspecification) {
		this.productspecification = productspecification;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public TotalProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TotalProducts [id=" + id + ", productname=" + productname + ", productdescription=" + productdescription
				+ ", productspecification=" + productspecification + ", size=" + size + ", gender=" + gender
				+ ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3 + ", category=" + category
				+ ", price=" + price + ", delivery=" + delivery + "]";
	}

		
	

}
