package com.results.response.repository;

import com.results.response.entity.UserResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserResponseRepository extends CrudRepository<UserResponse,Integer> {

}