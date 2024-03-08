package com.example.dto;

public class UserProductUpdateRequestDto {
	
	private int userCartId;
	
	private int quantity;
	
	private int productId;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserCartId() {
		return userCartId;
	}
	public void setUserCartId(int userProductId) {
		this.userCartId = userProductId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
