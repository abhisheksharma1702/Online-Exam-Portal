package com.ExamMicroservice.ExamMicroservice.repositories;

import com.ExamMicroservice.ExamMicroservice.entities.Examschedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamscheduleRepository extends JpaRepository<Examschedule,Long> {
    Examschedule findByUsername(String userName);
}
