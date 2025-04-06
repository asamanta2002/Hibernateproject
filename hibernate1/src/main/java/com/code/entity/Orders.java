package com.code.entity;

import java.util.*;
import jakarta.persistence.*;
import java.sql.*;

@Entity
@Table(name="orders")
public class Orders {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="orderDate", nullable=false)
	private Timestamp orderDate;
	
	@Column(name="totalAmount", nullable=false)
	private float totalAmount;
	
	// Many To One relationship with Users
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users user;
	
	// One To Many relationship with OrderDetails
	@OneToMany(cascade=CascadeType.ALL, mappedBy="order")
	private List<OrderDetails> orderDetils;
	
	// Constructors
	public Orders() {
		this.id = 0;
		this.orderDate = null;
		this.totalAmount = 0.0f;
		this.user = null;
		this.orderDetils = null;
	}
	public Orders(int id, Timestamp orderDate, float totalAmount, Users user, List<OrderDetails> orderDetils) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.user = user;
		this.orderDetils = orderDetils;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public Users getUser() {
		return user;
	}
	public List<OrderDetails> getOrderDetils() {
		return orderDetils;
	}
	
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public void setOrderDetils(List<OrderDetails> orderDetils) {
		this.orderDetils = orderDetils;
	}
	@Override
	public String toString() {
		return "Orders [Id: " + this.id + ", OrderDate: " + this.orderDate + ", TotalAmount: " + this.totalAmount + ", User: " + this.user
				+ ", OrderDetils: " + this.orderDetils + "]";
	}
	
		
} 