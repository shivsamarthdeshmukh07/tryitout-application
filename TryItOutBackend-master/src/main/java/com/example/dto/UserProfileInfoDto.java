package com.example.dto;

import javax.persistence.Column;

public class UserProfileInfoDto {
	private int userId;
	private String firstName;
	private String lastName;
	private String mobile;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "UserProfileInfoDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobile=" + mobile + "]";
	}
	
}
