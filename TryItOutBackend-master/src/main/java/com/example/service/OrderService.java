package com.example.service;



import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.dto.PaymentRequestDto;

public interface OrderService {
	
	public OrderResponseDto createOrder( OrderRequestDto order);
	
	public boolean orderPayment(PaymentRequestDto paymentdto);

}
