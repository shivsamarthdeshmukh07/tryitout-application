package com.example.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProfilePic {
	private int userId;
	
	private MultipartFile userProfilePic;

	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public MultipartFile getProfilePic() {
		return userProfilePic;
	}

	public void setProfilePic(MultipartFile userProfilePic) {
		this.userProfilePic = userProfilePic;
	}
	
}
