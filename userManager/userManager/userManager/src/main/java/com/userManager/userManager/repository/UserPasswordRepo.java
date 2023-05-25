package com.userManager.userManager.repository;

import com.userManager.userManager.entity.User;
import org.springframework.data.repository.Repository;

public interface UserPasswordRepo extends Repository<User,Integer>{

		public User findByEmail(String email);
}
