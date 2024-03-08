package com.example.dto;

import com.example.entity.Cart;
import com.example.entity.OrderItem;
import com.example.entity.PaymentDetails;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.entity.UserProducts;

public class UserOrdersResponseDto {

	private User u ;
	private PaymentDetails pd ;
	private Product product;
	private UserProducts up;
	private OrderItem oi ;
	private Cart c;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public PaymentDetails getPd() {
		return pd;
	}
	public void setPd(PaymentDetails pd) {
		this.pd = pd;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public UserProducts getUp() {
		return up;
	}
	public void setUp(UserProducts up) {
		this.up = up;
	}
	public OrderItem getOi() {
		return oi;
	}
	public void setOi(OrderItem oi) {
		this.oi = oi;
	}
	public Cart getC() {
		return c;
	}
	public void setC(Cart c) {
		this.c = c;
	}
	
}
