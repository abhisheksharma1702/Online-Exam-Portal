package com.userManager.userManager.repository;

import com.userManager.userManager.entity.User;
import org.springframework.data.repository.Repository;

public interface LoginRepository extends Repository<User, Integer> {
	
	public User findByEmailAndPassword(String email, String password);

	public User findByEmail(String email);

}
