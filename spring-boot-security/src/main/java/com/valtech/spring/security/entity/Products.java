package com.valtech.spring.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double price;
	private float weight;
	private String productDescription;
	private int quantity;
	
	
	
	
	
	
	public Products() {
	}
	public Products(double price, float weight, String productDescription, int quantity) {
		super();
		this.price = price;
		this.weight = weight;
		this.productDescription = productDescription;
		this.quantity = quantity;
	}
	
	
	
	public Products(int id, double price, float weight, String productDescription, int quantity) {
		super();
		this.id = id;
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
	@Override
	public String toString() {
		return "Products [id=" + id + ", price=" + price + ", weight=" + weight + ", productDescription="
				+ productDescription + ", quantity=" + quantity + "]";
	}
	
}
