package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;
import com.example.entity.UserAddress;

public interface GenricAddressRepo extends JpaRepository<UserAddress,Integer> {

	public UserAddress findByUserAndAddLine1AndAddLine2AndCity(User u, String a, String b , String c);
	
	public UserAddress findByIsDefault(boolean defaultvalue);
}
