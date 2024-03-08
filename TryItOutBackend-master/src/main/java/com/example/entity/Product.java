package com.example.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name = "product_table")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String Name;
	@Lob
	private String Description;

	private int quantity;
	private int price;
	private String productImg;
	

	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<UserProducts> userProdcuts;
	
	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	@UpdateTimestamp
	private Timestamp updationTimestamp;
	
	private String status;
	
	private String category;
	
	private String gender;
	
	private String colour;
	
	private String brand;
	
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public List<UserProducts> getUserProdcuts() {
		return userProdcuts;
	}

	public void setUserProdcuts(List<UserProducts> userProdcuts) {
		userProdcuts = userProdcuts;
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
	
	
	

}
