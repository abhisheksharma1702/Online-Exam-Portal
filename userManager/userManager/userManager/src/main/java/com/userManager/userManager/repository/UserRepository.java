package com.userManager.userManager.repository;

import com.userManager.userManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u JOIN Reports r on u.user_id = r.user_id where r.course_id = ?1 and u.state = ?2 and u.city = ?3 and r.level_1 >= ?4")
	List<User> findAllUsersLevel1(int course_id, String state, String city, int marks);

	@Query("SELECT u FROM User u JOIN Reports r on u.user_id = r.user_id where r.course_id = ?1 and u.state = ?2 and u.city = ?3 and r.level_2 >= ?4")
	List<User> findAllUsersLevel2(int course_id, String state, String city, int marks);
	
	@Query("SELECT u FROM User u JOIN Reports r on u.user_id = r.user_id where r.course_id = ?1 and u.state = ?2 and u.city = ?3 and r.level_3 >= ?4")
	List<User> findAllUsersLevel3(int course_id, String state, String city, int marks);

    User findByEmail(String s);
}

