package com.userservice.services;

//import java.util.List;

//import com.lti.dto.AdminSearchStudent;

import com.userservice.entity.AdminLoginDetail;
import com.userservice.exception.UserServiceException;

public interface AdminService {

	public AdminLoginDetail login(String email, String password)  throws UserServiceException;
	

}
