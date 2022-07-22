package com.example.demo.dto;



public class RefundDto {

	private int id;
	
	private int userid;
	
	private String username;
	
	private String productname;
	
	private String paymentid;
	
	private String price;
	
	private int orderid;
	
	private String refundstatus = "Nike Team Working On The Request";
	
	
	//Getters And Setters
	
	public String getRefundstatus() {
		return refundstatus;
	}

	public void setRefundstatus(String refundstatus) {
		this.refundstatus = refundstatus;
	}

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

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	
	public RefundDto() {
		super();
	}
	
	
}
