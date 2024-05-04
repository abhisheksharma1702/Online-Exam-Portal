package com.userservice.services;


import com.userservice.entity.AdminLoginDetail;
import com.userservice.exception.UserServiceException;
import com.userservice.repository.*;
import com.userservice.repository.AdminLoginRepository;
import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public AdminLoginDetail login(String email, String password) throws UserServiceException {
		AdminLoginDetail adminUser = adminLoginRepository.findByEmailAndPassword(email, password);
		if(adminUser==null)
			throw new UserServiceException("Incorrect Email or Password");
		return adminUser;
	}



}

