package com.reportservice.repository;

import com.reportservice.dto.ReportCompKey;
import com.reportservice.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportsDao extends JpaRepository<Reports, ReportCompKey> {


}
