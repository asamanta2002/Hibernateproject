package com.code.entity;


import jakarta.persistence.*;

@Entity
@Table(name="orderdetails")
public class OrderDetails {
	// Attributes
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantity", nullable = false)
	private int quantity;
	
	@Column(name="unitPrice", nullable = false)
	private float unitPrice;
	
	// Many To One relationship with Orders
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Orders order;
	
	// Many To One relationship with Product
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;
	
	// Constructors
	public OrderDetails() {
		this.id = 0;
		this.quantity = 0;
		this.unitPrice = 0.0f;
		this.order = null;
		this.product = null;
	}

	public OrderDetails(int id, int quantity, float unitPrice, Orders order, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.order = order;
		this.product = product;
	}

	// Getters 
	public int getId() {
		return id;
	}
	public int getQuantity() {
		return quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public Orders getOrder() {
		return order;
	}
	public Product getProduct() {
		return product;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	// toString
	@Override
	public String toString() {
		return "OrderDetails [Id: " + this.id + ", Quantity: " + this.quantity + ", UnitPrice: " + this.unitPrice + ", Order: " + this.order
				+ ", Product: " + this.product + "]";
	}
	
	
}
