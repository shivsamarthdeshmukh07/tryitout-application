package com.example.service;

import java.util.List;

import com.example.dto.CartProductsRequestDto;
import com.example.dto.CartProductsResponseDto;
import com.example.dto.UserAddressDto;
import com.example.dto.UserLoginDto;
import com.example.dto.UserProductDeleteRequestDto;
import com.example.dto.UserProductUpdateRequestDto;
import com.example.dto.UserProfileInfoDto;
import com.example.entity.User;
import com.example.entity.UserProducts;
import com.example.utility.UserProfileDto;

public interface UserService {

	public User addUser(User u);
	
	public UserLoginDto authenticateUser(UserLoginDto uld);
	
	public User getUserById(int id);
	
	public UserProducts addtoCartProduct(CartProductsRequestDto c);
	
	public List<CartProductsResponseDto> getAllCartProducts(int cartid);
	
	public boolean updateUserProductQuantityByadd1(UserProductUpdateRequestDto updto);
	
	public boolean updateUserProductQuantityBySub1(UserProductUpdateRequestDto updto);
	
	public boolean deleteProductFromTheCart(UserProductDeleteRequestDto delprod);
	
	public UserProfileDto getUserProfileInfo(int id);
	
	public Boolean clearCart(int cartId);
	
	public boolean updateAddress(UserAddressDto uAdd);
	
	public boolean userInfoUpdate(UserProfileInfoDto userDto);
}
