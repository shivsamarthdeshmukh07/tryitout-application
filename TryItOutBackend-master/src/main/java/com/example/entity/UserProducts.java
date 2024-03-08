package com.example.entity;

import java.sql.Timestamp;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
@Entity
@Table(name = "User_Products")
public class UserProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cartId", nullable=false)
	private Cart cart;
	@ManyToOne
	@JoinColumn(name="productId", nullable=false)
	private Product product;
	
	private String size;
	
	private String colour;
	
	private int quantity;

	private String visiblity;

	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	@UpdateTimestamp
	private Timestamp updationTimestamp;
	
	
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getVisiblity() {
		return visiblity;
	}

	public void setVisiblity(String visiblity) {
		this.visiblity = visiblity;
	}
	
	
}
