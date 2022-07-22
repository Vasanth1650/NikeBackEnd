package com.example.demo.dto;



public class WishListNormalDto {
	

	private int id;
	
	private String userid;
	
	private String productid;
	
	private String productname;
	
	private String username;
	
	private String image1;
	
	
	//Getters And Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public WishListNormalDto() {
		super();
	}
	
	
	//ToString Helps To Return The Value In String
	@Override
	public String toString() {
		return "WishList [id=" + id + ", userid=" + userid + ", productid=" + productid + ", productname=" + productname
				+ ", username=" + username + ", image1=" + image1 + "]";
	}
	
	

}