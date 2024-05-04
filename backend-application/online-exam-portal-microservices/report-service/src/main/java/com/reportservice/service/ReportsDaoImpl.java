package com.reportservice.service;

import com.reportservice.repository.ReportsDao;
import com.reportservice.dto.ReportCompKey;
import com.reportservice.entity.Reports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class ReportsDaoImpl {

    @Autowired
    ReportsDao repository;

    @Transactional
    public boolean reportExists(ReportCompKey reportCompKey) {

        Optional<Reports> r = repository.findById(reportCompKey);
        System.out.println(r);
        if (r.isPresent()) {
            return true;
        }
        else return false;
    }

}