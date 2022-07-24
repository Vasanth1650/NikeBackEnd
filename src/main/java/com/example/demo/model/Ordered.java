/**This Class Will Helps To Store After Successful Payment The Ordered Items Will Be Stored And The Common Entity To
 * Send The Package Will Be Used To Store In This Entity 
 * @author Vasanth
 * **/


package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordered {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String address;
	
	private String state;
	
	private String city;
	
	private String payment;
	
	private String productname;
	
	@Column(name="userid")
	private int userid;
	
	private String status;
	
	private String paymentid;
	
	private String status1 = "active current";
	
	private String status2;
	
	private String status3;
	
	private String status4;
	
	private String status5;
	

	//Getters And Setters
	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getStatus3() {
		return status3;
	}

	public void setStatus3(String status3) {
		this.status3 = status3;
	}

	public String getStatus4() {
		return status4;
	}

	public void setStatus4(String status4) {
		this.status4 = status4;
	}

	public String getStatus5() {
		return status5;
	}

	public void setStatus5(String status5) {
		this.status5 = status5;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	//Super Constructor Which Help To Refer To The Base Or Parent Class
	public Ordered() {
		super();
	}
	
	

}  
