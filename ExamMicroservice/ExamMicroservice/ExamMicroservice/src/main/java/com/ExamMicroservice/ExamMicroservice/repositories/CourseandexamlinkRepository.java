package com.ExamMicroservice.ExamMicroservice.repositories;

import com.ExamMicroservice.ExamMicroservice.entities.Courseandexamlinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseandexamlinkRepository extends JpaRepository<Courseandexamlinks,Long> {
//    @Query("SELECT s.examlink FROM courseandexamlinks s WHERE s.coursename = (s.coursename)")
//    String findById(String coursename);
}
