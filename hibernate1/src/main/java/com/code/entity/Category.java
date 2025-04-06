package com.code.entity;


import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {
	// Attributes
	@Id // Primary Key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Auto increment
	private int id;
	
	@Column(name="name", length=20, unique=true, nullable=false)
	private String name;
	
	@Column(name="description",length=100)
	private String description;
	
	// One To Many relationship with Product
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	private List<Product> products;
	
	// Constructors
	public Category(){
		this.id = 0;
		this.name = null;
		this.description = null;
		products = null;
	}
	public Category(String name, String description) {
		this();
		this.name = name;
		this.description = description;
	}
	
	// Getters 
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}
	public List<Product> getProducts() {
		return products;
	}
	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	// toString
	@Override
	public String toString() {
		return "Category [ID: "+this.id+", Name: "+this.name+", Description: "+this.description+" ]";
	}
}
