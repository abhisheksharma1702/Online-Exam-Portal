package com.userManager.userManager.repository;

import com.userManager.userManager.entity.AdminLoginDetail;
import org.springframework.data.repository.Repository;

public interface AdminLoginRepository extends Repository<AdminLoginDetail, Integer>{

	public AdminLoginDetail findByEmailAndPassword(String emailId,String password);

	public AdminLoginDetail findByEmail(String emailId);
}
