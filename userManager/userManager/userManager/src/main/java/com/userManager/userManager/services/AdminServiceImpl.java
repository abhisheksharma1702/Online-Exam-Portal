package com.userManager.userManager.services;


import com.userManager.userManager.entity.AdminLoginDetail;
import com.userManager.userManager.exception.UserServiceException;
import com.userManager.userManager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminLoginRepository adminLoginRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public AdminLoginDetail login(String email, String password) throws UserServiceException{
		AdminLoginDetail adminUser = adminLoginRepository.findByEmailAndPassword(email, password);
		if(adminUser==null)
			throw new UserServiceException("Incorrect Email or Password");
		return adminUser;
	}



}

