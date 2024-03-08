package com.example.service;

import java.time.LocalDateTime;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.OrderRequestDto;
import com.example.dto.OrderResponseDto;
import com.example.dto.PaymentRequestDto;
import com.example.entity.OrderItem;
import com.example.entity.PaymentDetails;
import com.example.repository.GenericCartRepo;
import com.example.repository.GenericOrderRepo;
import com.example.repository.GenericPaymentRepo;
import com.example.repository.GenericUserRepository;
import com.example.repository.GenericUserProductRepo;
import com.example.repository.GenericUserRepository;
import com.example.utility.UserDefinedUserProductsDto;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class OrderServiceImple implements OrderService {


	@Autowired
	private GenericCartRepo genCartRepo;
	
	@Autowired
	private GenericOrderRepo genOrderRepo;
	
	@Autowired
	private GenericPaymentRepo genPaymentRepo;

	@Autowired
	private GenericUserRepository genUserRepo;
	
	@Autowired
	private GenericUserProductRepo genUserPorductRepo;
	
	
	@Override
	public OrderResponseDto createOrder(OrderRequestDto order) {
		Order razorOrder;
		
		OrderItem  userOrder = new OrderItem();
		
		OrderResponseDto orderInfo = new OrderResponseDto();
		try {
			RazorpayClient client = new RazorpayClient("rzp_test_0ANxMyDNRQqqnh", "284dRuK13Yyy2UeWKafenB6u");
			
			JSONObject options = new JSONObject();
			options.put("amount", order.getAmount()*100);
			options.put("currency", "INR");
			options.put("receipt", "txn_123456");
			razorOrder = client.Orders.create(options);
			
			orderInfo.setId(order.getId());
			orderInfo.setAmount(razorOrder.get("amount"));
			orderInfo.setOrderId(razorOrder.get("id"));
			orderInfo.setStatus(razorOrder.get("status"));
			orderInfo.setAttempts(razorOrder.get("attempts"));
			
			
			userOrder.setAmount(razorOrder.get("amount"));
			
			userOrder.setAttempts(razorOrder.get("attempts"));
			
			System.out.println(order.getId());
			
			userOrder.setCart(genCartRepo.findById(order.getId()).get());
			
			userOrder.setDate(razorOrder.get("created_at"));
			
			userOrder.setOrderId(razorOrder.get("id"));
			
			userOrder.setReceipt(razorOrder.get("receipt"));
			
			userOrder.setStatus(razorOrder.get("status"));
			
			genOrderRepo.save(userOrder);
			
			return orderInfo;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
			orderInfo.setAmount(order.getAmount());
			orderInfo.setStatus("failed");
			return orderInfo;
		}
		
	}

	@Override
	public boolean orderPayment(PaymentRequestDto paymentdto) {
		try {
			
			PaymentDetails payment = new PaymentDetails();
			
			payment.setAmount(paymentdto.getAmount());
			
			payment.setOrder(genOrderRepo.findById(paymentdto.getOrderId()).get());
			
			payment.setPaymentDate(LocalDateTime.now());
			
			payment.setPaymentId(paymentdto.getPaymentId());
			
			payment.setSignature(paymentdto.getSignature());
			
			payment.setUser(genUserRepo.findById(paymentdto.getUserId()).get());
			
			payment.setProvider("Razor Pay");
			
			payment.setStatus(paymentdto.getStatus());
				
			genPaymentRepo.save(payment);
			
			return true;
		}
		catch(Exception e) {
		e.printStackTrace();
			throw e;
		}
		
	}
	
	public List<UserDefinedUserProductsDto> userOrdersInfo (int uid ){
		
		try {
			System.out.println(uid);
			
			return genUserPorductRepo.getAllOrderDetails(uid);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
	}
}
