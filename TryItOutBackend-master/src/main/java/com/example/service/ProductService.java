package com.example.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.entity.Product;

public interface ProductService {

	public Product addProduct(Product p);
	
	public boolean deleteProduct(int id);
}
