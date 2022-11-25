package com.valtech.spring.security.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String productName;
	private double price;
	private float weight;
	private String productDescription;
	private int quantity;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	private int userid;

	public Products() {
	}
	
	
	public Products(String productName,double price, float weight, String productDescription, int quantity) {
		super();
		this.productName=productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		
		
	}
	
	
	
	public Products(int id, String productName,double price, float weight, String productDescription, int quantity) {
		super();
		this.id = id;
		this.productName=productName;
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
		
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	


	
	

	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", price=" + price + ", weight=" + weight
				+ ", productDescription=" + productDescription + ", quantity=" + quantity + "]";
	}
	
	
}
