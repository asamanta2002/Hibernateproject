package com.code.entity;


import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
	// Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username",length=20, unique=true, nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private int password;	// have to hash and store
	
	@Column(name="email", length=30, unique=true, nullable=false)
	private String email;
	
	@Enumerated(EnumType.STRING) // This attribute is Enumerated with String type
	@Column(name="role")
	private Role role;	
	
	// One To Many relation with Orders
	// The entity with @ManyToOne relationship is the owning side of the relation
	// in the mappedBy we have to give the name of the field that owns the relation
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Orders> orders;
	
	// Constructors
	public Users() {
		this.id = 0;
		this.username = null;
		this.password = 0;
		this.email = null;
		this.role = null;
	}
	public Users(String username, String password, String email, Role role) {
		this();
		this.username = username;
		this.password = hashPassword(password);
		this.email = email;
		this.role = role;
	}
	
	// Getters
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public int getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public Role getRole() {
		return role;
	}
	public List<Orders> getOrders() {
		return orders;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = hashPassword(password);
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	// Hashing the password
	private int hashPassword(String password) {
		return Objects.hash(password);
	}
	
	// Checking password match
	private boolean checkHash(String inputPassword) {
		if(inputPassword == null)
			return false;
		int inputHash = Objects.hash(inputPassword);
		return Objects.equals(this.password, inputHash);
	}
	
	// to String
	@Override
	public String toString() {
		return "Users [Id: " + this.id + ", Username: " + this.username + ", Password: " + this.password + ", Email: " + this.email + ", Role: "
				+ this.role + ", Orders: " + this.orders + "]";
	}
	
	
}
