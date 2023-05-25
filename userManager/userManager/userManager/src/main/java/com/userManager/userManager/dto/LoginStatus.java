package com.userManager.userManager.dto;

public class LoginStatus extends Status {

	//in case we want to return all the details of Customer on login
	//then declare Customer object here-> private Customer customer; 
	private int userId;

	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	
	
}

