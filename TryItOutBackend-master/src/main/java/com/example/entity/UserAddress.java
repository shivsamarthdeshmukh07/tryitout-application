package com.example.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user_address")
public class UserAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int AddressId;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	private User user;
	private String addLine1;
	private String addLine2;
	private String city;
	private int PostalCode;
	private String country;
	private String state;
	private String fname;
	private String lname;
	private boolean isDefault;
	
	public boolean isDefault() {
		return isDefault;
	}
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	public String getFname() {	
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
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
	public int getAddressId() {
		return AddressId;
	}
	public void setAddressId(int addressId) {
		AddressId = addressId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAddLine1() {
		return addLine1;
	}
	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}
	public String getAddLine2() {
		return addLine2;
	}
	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "UserAddress [AddressId=" + AddressId + ", addLine1=" + addLine1 + ", addLine2=" + addLine2 + ", city="
				+ city + ", PostalCode=" + PostalCode + ", country=" + country + ", state=" + state + ", fname=" + fname
				+ ", lname=" + lname + ", isDefault=" + isDefault + ", creationTimestamp=" + creationTimestamp
				+ ", updationTimestamp=" + updationTimestamp + "]";
	}
	
	
	

}
