package com.ExamMicroservice.ExamMicroservice.repositories;
import com.ExamMicroservice.ExamMicroservice.entities.Proctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProctorRepository extends JpaRepository<Proctor,Long> {
}
