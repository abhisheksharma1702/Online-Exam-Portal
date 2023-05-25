package com.userManager.userManager.controller;

import com.userManager.userManager.dto.Status;
import com.userManager.userManager.exception.UserServiceException;
import com.userManager.userManager.repository.UserRepository;
import com.userManager.userManager.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.userManager.userManager.dto.Login;
import com.userManager.userManager.dto.LoginStatus;
import com.userManager.userManager.entity.AdminLoginDetail;

@RestController
@RequestMapping("/auth/admin-restapi")
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService adminService;

	
	@Autowired
	private UserRepository userRepo;

	
	@PostMapping("/admin_login") 
	public LoginStatus adminLogin(@RequestBody Login login) {
		try {
			AdminLoginDetail admin = adminService.login(login.getEmail(),login.getPassword());
			System.out.println(admin);
			LoginStatus status = new LoginStatus();
			status.setStatus(Status.StatusType.SUCCESS);
			status.setMessage("Login Successful!");
			status.setUserId(admin.getAdminId());
			return status;
		} catch (UserServiceException e) {
			LoginStatus status = new LoginStatus();
			status.setStatus(Status.StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	@GetMapping("/")
	public String helloAdmin(){
		return "I am from admin controller in auth Service ";
	}
	
}
