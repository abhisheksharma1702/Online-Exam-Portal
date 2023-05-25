package com.results.response.service;

import com.results.response.dto.ReportCompKey;
import com.results.response.dto.SubmitResponse;
import com.results.response.entity.Reports;
import com.results.response.repository.ReportRepository;
import com.results.response.repository.ReportsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserServiceImpl {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private Reports report;

    @Autowired
    private ReportCompKey reportCompositeKey;

    @Autowired
    private ReportsDao reportDao;

    @Transactional
    public void savingMarks(SubmitResponse submitResponse) {
        reportCompositeKey.setUser_id(submitResponse.getUserId());
        reportCompositeKey.setCourse_id(submitResponse.getCourseId());
//		report.setReportCompKey(reportCompositeKey);
        report.setUser_id(submitResponse.getUserId());
        report.setCourse_id(submitResponse.getCourseId());

        if(submitResponse.getLevelId() == 1) {
            report.setLevel_1(submitResponse.getMarks());
            reportDao.save(report);}

    }


    @Transactional
    public List<Reports> generateUserReports(int user_id) {
        List<Reports> list = reportRepository.findAll(user_id);
        return list;
    }
}
