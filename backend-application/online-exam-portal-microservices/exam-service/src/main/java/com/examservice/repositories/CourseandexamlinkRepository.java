package com.examservice.repositories;

import com.examservice.entities.Courseandexamlinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseandexamlinkRepository extends JpaRepository<Courseandexamlinks,Long> {
//    @Query("SELECT s.examlink FROM courseandexamlinks s WHERE s.coursename = (s.coursename)")
//    String findById(String coursename);
}
