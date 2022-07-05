/** 
 * TotalProducts Entity Will Used To Store The Regular Products Which Contains Normal Information Rather Than The
 * Special One 
 * @author Vasanth
 **/


package com.example.demo.model;

import javax.persistence.Column;
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
	
	@Column(length=1500)
	private String productdescription;
	
	@Column(length=1500)
	private String productspecification1;
	
	@Column(length=1500)
	private String productspecification2;
	
	@Column(length=1500)
	private String productspecification3;
	
	@Column(length=1500)
	private String productspecification4;
	
	@Column(length=1500)
	private String productspecification5;
	
	private String size1;
	
	private String size2;
	
	private String size3;
	
	private String size4;
	
	private String size5;
	
	private String gender;
	
	@Column(length=1500)
	private String image1;
	
	@Column(length=1500)
	private String image2;
	
	@Column(length=1500)
	private String image3;
	
	@Column(length=1500)
	private String image4;
	
	@Column(length=1500)
	private String image5;
	
	@Column(length=1500)
	private String image6;
	
	@Column(length=1500)
	private String image7;
	
	@Column(length=1500)
	private String image8;
	
	@Column(length=1500)
	private String image9;
	
	@Column(length=1500)
	private String image10;
	
	@Column(length=1500)
	private String image11;
	
	@Column(length=1500)
	private String image12;
	
	private String category1;
	
	private String category2;
	
	private String category3;
	
	private String price;
	
	@Column(length=1500)
	private String delivery;
	
	@Column(length=1500)
	private String collection;
	
	//Getters And Setters
		
	public String getCollection() {
		return collection;
	}

	public String getImage4() {
		return image4;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

	public String getImage5() {
		return image5;
	}

	public void setImage5(String image5) {
		this.image5 = image5;
	}

	public String getImage6() {
		return image6;
	}

	public void setImage6(String image6) {
		this.image6 = image6;
	}

	public String getImage7() {
		return image7;
	}

	public void setImage7(String image7) {
		this.image7 = image7;
	}

	public String getImage8() {
		return image8;
	}

	public void setImage8(String image8) {
		this.image8 = image8;
	}

	public String getImage9() {
		return image9;
	}

	public void setImage9(String image9) {
		this.image9 = image9;
	}

	public String getImage10() {
		return image10;
	}

	public void setImage10(String image10) {
		this.image10 = image10;
	}

	public String getImage11() {
		return image11;
	}

	public void setImage11(String image11) {
		this.image11 = image11;
	}

	public String getImage12() {
		return image12;
	}

	public void setImage12(String image12) {
		this.image12 = image12;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

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
	}

	
	//ToString Helps To Return The Value In String
	@Override
	public String toString() {
		return "TotalProducts [id=" + id + ", productname=" + productname + ", productdescription=" + productdescription
				+ ", productspecification1=" + productspecification1 + ", productspecification2="
				+ productspecification2 + ", productspecification3=" + productspecification3
				+ ", productspecification4=" + productspecification4 + ", productspecification5="
				+ productspecification5 + ", size1=" + size1 + ", size2=" + size2 + ", size3=" + size3 + ", size4="
				+ size4 + ", size5=" + size5 + ", gender=" + gender + ", image1=" + image1 + ", image2=" + image2
				+ ", image3=" + image3 + ", category1=" + category1 + ", category2=" + category2 + ", category3="
				+ category3 + ", price=" + price + ", delivery=" + delivery + "]";
	}

	

		
	

}
