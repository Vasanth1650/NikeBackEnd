/**Product Entity Class Used To Store The Most Popular Which Contains More Information Than The Regular One Provide
 * Acts As The Base Of The Most Popular Products
 * @author Vasanth
 * **/

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
	
	private int productprice;
	
	private String size1;
	
	private String size2;
	
	private String size3;
	
	private String size4;
	
	private String size5;
	
	private String productspecification1;
	
	private String productspecification2;
	
	private String productspecification3;
	
	private String productspecification4;
	
	private String productspecification5;
	
	private String productimage1;
	
	private String productimage2;
	
	private String productimage3;
	
	private String productimage4;
	
	private String productimage5;
	
	private String productimage6;
	
	private String productimage7;
	
	private String productimage8;
	
	private String productimage9;
	
	private String productimage10;
	
	private String productimage11;
	
	private String productimage12;
	
	private String gender;
	
	private String category1;
	
	private String category2;
	
	private String category3;
	
	
	//Getters And Setters

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

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getSize1() {
		return size1;
	}

	public void setSize1(String size1) {
		this.size1 = size1;
	}

	public String getSize2() {
		return size2;
	}

	public void setSize2(String size2) {
		this.size2 = size2;
	}

	public String getSize3() {
		return size3;
	}

	public void setSize3(String size3) {
		this.size3 = size3;
	}

	public String getSize4() {
		return size4;
	}

	public void setSize4(String size4) {
		this.size4 = size4;
	}

	public String getSize5() {
		return size5;
	}

	public void setSize5(String size5) {
		this.size5 = size5;
	}

	public String getProductspecification1() {
		return productspecification1;
	}

	public void setProductspecification1(String productspecification1) {
		this.productspecification1 = productspecification1;
	}

	public String getProductspecification2() {
		return productspecification2;
	}

	public void setProductspecification2(String productspecification2) {
		this.productspecification2 = productspecification2;
	}

	public String getProductspecification3() {
		return productspecification3;
	}

	public void setProductspecification3(String productspecification3) {
		this.productspecification3 = productspecification3;
	}

	public String getProductspecification4() {
		return productspecification4;
	}

	public void setProductspecification4(String productspecification4) {
		this.productspecification4 = productspecification4;
	}

	public String getProductspecification5() {
		return productspecification5;
	}

	public void setProductspecification5(String productspecification5) {
		this.productspecification5 = productspecification5;
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

	public String getProductimage4() {
		return productimage4;
	}

	public void setProductimage4(String productimage4) {
		this.productimage4 = productimage4;
	}

	public String getProductimage5() {
		return productimage5;
	}

	public void setProductimage5(String productimage5) {
		this.productimage5 = productimage5;
	}

	public String getProductimage6() {
		return productimage6;
	}

	public void setProductimage6(String productimage6) {
		this.productimage6 = productimage6;
	}

	public String getProductimage7() {
		return productimage7;
	}

	public void setProductimage7(String productimage7) {
		this.productimage7 = productimage7;
	}

	public String getProductimage8() {
		return productimage8;
	}

	public void setProductimage8(String productimage8) {
		this.productimage8 = productimage8;
	}

	public String getProductimage9() {
		return productimage9;
	}

	public void setProductimage9(String productimage9) {
		this.productimage9 = productimage9;
	}

	public String getProductimage10() {
		return productimage10;
	}

	public void setProductimage10(String productimage10) {
		this.productimage10 = productimage10;
	}

	public String getProductimage11() {
		return productimage11;
	}

	public void setProductimage11(String productimage11) {
		this.productimage11 = productimage11;
	}

	public String getProductimage12() {
		return productimage12;
	}

	public void setProductimage12(String productimage12) {
		this.productimage12 = productimage12;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}
			
	
	
}
