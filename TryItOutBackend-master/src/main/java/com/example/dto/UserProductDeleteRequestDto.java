package com.example.dto;

public class UserProductDeleteRequestDto {

	private int userCartId;
	private int productId;
	public int getUserCartId() {
		return userCartId;
	}
	public void setUserCartId(int userCartId) {
		this.userCartId = userCartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
