package com.userManager.userManager.services;

//import java.util.List;

//import com.lti.dto.AdminSearchStudent;

import com.userManager.userManager.entity.AdminLoginDetail;
import com.userManager.userManager.exception.UserServiceException;

public interface AdminService {

	public AdminLoginDetail login(String email, String password)  throws UserServiceException;
	

}
