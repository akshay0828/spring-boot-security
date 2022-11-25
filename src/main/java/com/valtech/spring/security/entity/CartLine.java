package com.valtech.spring.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
@Entity
public class CartLine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	private int prodid;
	
	private String productName;
	private double price;
	private int quantity=1;
	
	
	
	
	
	
	
	
	
	
	
	
	public CartLine(int prodid, String productName, double price, int quantity) {
		super();
		this.prodid = prodid;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public CartLine(int id, int prodid, String productName, double price, int quantity) {
		super();
		this.id = id;
		this.prodid = prodid;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	public CartLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartLine [id=" + id + ", prodid=" + prodid + ", productName=" + productName + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	

}
