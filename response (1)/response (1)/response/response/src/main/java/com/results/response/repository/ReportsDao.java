package com.results.response.repository;

import com.results.response.dto.ReportCompKey;
import com.results.response.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportsDao extends JpaRepository<Reports, ReportCompKey> {


}
