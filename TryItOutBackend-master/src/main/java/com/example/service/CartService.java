package com.example.service;

import com.example.entity.Cart;

public interface CartService {
	
	public Cart addUserCart(Cart c);
  
	public int getCartId(int uid);

}
