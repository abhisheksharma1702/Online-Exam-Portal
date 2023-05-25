package com.results.response.repository;

import com.results.response.entity.Reports;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ReportRepository extends CrudRepository<Reports,Integer> {

    @Query("SELECT r FROM Reports r where r.user_id = ?1")
    public List<Reports> findAll(int user_id);
}
