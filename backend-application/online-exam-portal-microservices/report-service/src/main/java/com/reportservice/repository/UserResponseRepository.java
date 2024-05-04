package com.reportservice.repository;

import com.reportservice.entity.UserResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserResponseRepository extends CrudRepository<UserResponse,Integer> {

}