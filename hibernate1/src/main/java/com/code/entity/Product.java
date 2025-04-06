package com.code.entity;


import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name",length=20, nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private float price;
	
	@Column(name="stockQuantity")
	private int stockQuantity;
	
	// Many To One Relationship with Category
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id",nullable=false)
	private Category category;
	
	// One to Many relationship with OrderDetails
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<OrderDetails> orderDetails;
	
	
	// Constructors
	public Product() {
		this.id = 0;
		this.name = null;
		this.price = 0.0f;
		this.stockQuantity = 0;
	}
	public Product(String name, float price, int stockQuantity, Category category) {
		this();
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.category = category;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	// toString
	@Override
	public String toString() {
		return "Product [Id: " + this.id + ", Name=" + this.name + ", Price=" + this.price + ", StockQuantity=" + this.stockQuantity
				+ ", Category=" + this.category + "]";
	}	
}
