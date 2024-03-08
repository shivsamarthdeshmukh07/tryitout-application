package com.example.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
 
	@Autowired
	private JavaMailSender emailSender;
	
	public int sendEmailForOTP(String email) {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		Random random = new Random();
		
		int otp = random.nextInt(100000,999999);
		
		msg.setFrom("shiv130799@gmail.com");
		
		msg.setTo(email);
		
		msg.setSubject("OTP CONFIRMATION");
		
		msg.setText("HEY BOY. YE LE OTP :"+otp);
		
		emailSender.send(msg);
		
		return otp;
	}
}
