package com.userservice.services;

import com.userservice.entity.User;
import com.userservice.exception.UserServiceException;
import com.userservice.repository.*;
import com.userservice.repository.LoginRepository;
import com.userservice.repository.UserPasswordRepo;
import com.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoginRepository loginRepo;
	

	@Autowired
	private UserPasswordRepo userPassRepo;
	

	@Transactional
	public int register(User user) {
		User userExists = loginRepo.findByEmail(user.getEmail());
		if(userExists!=null) {
			throw new UserServiceException("User already registered!");
		}
		User updatedUser = (User) userRepository.save(user);
		return updatedUser.getUser_id();


	}
	
	@Transactional
	public User login(String email, String password) {
//			System.out.println(email + " " + password);
			User user = loginRepo.findByEmailAndPassword(email,password);
			if(user==null)
				throw new UserServiceException("Incorrect Email or Password");
			return user;

	}

	
}

