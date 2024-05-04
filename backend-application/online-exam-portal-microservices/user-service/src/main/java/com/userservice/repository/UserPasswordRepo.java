package com.userservice.repository;

import com.userservice.entity.User;
import org.springframework.data.repository.Repository;

public interface UserPasswordRepo extends Repository<User,Integer>{

		public User findByEmail(String email);
}
