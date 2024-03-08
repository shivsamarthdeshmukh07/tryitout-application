package com.example.dto;


import com.example.entity.Role;


public class UserLoginDto {
	
	private String email;
	
	private String password;
	
	private boolean status;
	
	private int userId;
	
	private Role role;
	
	private String userImg;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Role getRoleId() {
		return role;
	}

	public void setRoleId(Role roleId) {
		this.role = roleId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}