package com.examservice.repositories;

import com.examservice.entities.Examschedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamscheduleRepository extends JpaRepository<Examschedule,Long> {
    Examschedule findByUsername(String userName);
}
