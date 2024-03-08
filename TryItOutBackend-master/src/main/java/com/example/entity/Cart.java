package com.example.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cart_table")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@OneToOne
	@JoinColumn 
	private User user;
	
	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	@UpdateTimestamp
	private Timestamp updationTimestamp;
	
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Timestamp getUpdationTimestamp() {
		return updationTimestamp;
	}

	public void setUpdationTimestamp(Timestamp updationTimestamp) {
		this.updationTimestamp = updationTimestamp;
	}

	@OneToMany(mappedBy = "cart")
	@JsonIgnore
	private List<UserProducts> userProducts;
	
	@OneToMany(mappedBy = "cart")
	private List<OrderItem> OrderItems;
	

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserProducts> getUserProducts() {
		return userProducts;
	}

	public void setUserProducts(List<UserProducts> userProducts) {
		this.userProducts = userProducts;
	}

	public List<OrderItem> getOrderItems() {
		return OrderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		OrderItems = orderItems;
	}
	
	
}
