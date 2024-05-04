package com.examservice.repositories;
import com.examservice.entities.Proctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProctorRepository extends JpaRepository<Proctor,Long> {
}
