package com.example.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "payment_table")
public class PaymentDetails {
	
	@Id
	private String paymentId;
	
	@OneToOne
	@JoinColumn(name="orderId", nullable=false)
	private OrderItem order;
	private int amount;
	private String provider;
	private String status;
	
	private String signature;
	
	@CreationTimestamp
	private Timestamp creationTimestamp;
	
	@UpdateTimestamp
	private Timestamp updationTimestamp;
	
	
	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

	@ManyToOne
	@JoinColumn(name="userId", nullable=false)
	@JsonIgnore
	private User user;
	
//	@JsonFormat(pattern = "dd/mm/yyyy HH:MM:SS")
	private LocalDateTime PaymentDate;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public OrderItem getOrder() {
		return order;
	}

	public void setOrder(OrderItem order) {
		this.order = order;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		PaymentDate = paymentDate;
	}
	
	
	
}
