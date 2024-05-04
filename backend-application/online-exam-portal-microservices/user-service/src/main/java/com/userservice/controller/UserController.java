package com.userservice.controller;

import com.userservice.dto.*;
import com.userservice.dto.Login;
import com.userservice.dto.LoginStatus;
import com.userservice.dto.RegisterStatus;
import com.userservice.entity.User;
import com.userservice.exception.UserServiceException;
import com.userservice.services.UserServiceImpl;
import com.userservice.dto.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/user-restapi")
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

	@Autowired
	private UserServiceImpl userService;

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/register")
	public RegisterStatus register(@RequestBody User user) {
		try {
//			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			int id = userService.register(user);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Registration Successful!");
			status.setRegisteredCustomerId(id);
			return status;
		} catch (UserServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(Status.StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}

	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		try {
			System.out.println(login.getEmail() + " " + login.getPassword());
			User user = userService.login(login.getEmail(),login.getPassword());
			System.out.println(user);
			LoginStatus status = new LoginStatus();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Login Successful!");
			status.setUserId(user.getUser_id());
			return status;
		} catch (UserServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(Status.StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;

		}
	}
	@GetMapping("/")
	public String hello(){
		return "I am from user controller in auth Service ";
	}

}
