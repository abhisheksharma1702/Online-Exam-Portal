package com.results.response.controller;

import com.results.response.dto.ReportCompKey;
import com.results.response.dto.SubmitResponse;
import com.results.response.entity.Reports;
import com.results.response.service.ReportsDaoImpl;
import com.results.response.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/report/user-restapi")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class UserController {
    @Autowired
    private ReportsDaoImpl reportsDao;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/submit_answers")
    public String getUserResponse(@RequestBody SubmitResponse submitResponse) {
        userService.savingMarks(submitResponse);
        float marks = (float) submitResponse.getMarks();
        float totalQuestions = (float) submitResponse.getTotalQuestions();
        float percentageScored = (marks/(totalQuestions * 10)) * 100;
        log.info("Percentage" + percentageScored);
        if(submitResponse.getLevelId() == 1 && percentageScored >= 50) {
            return "Pass";}
        else {
            return "Fail";
        }
    }



    @GetMapping("/report/{user_id}")
    public List<Reports> getUserReports(@PathVariable String user_id) {
        List<Reports> list = userService.generateUserReports(Integer.parseInt(user_id));
        return list;
    }
    @GetMapping("/exam_selection/{course_id}/{user_id}")
    public boolean examSelection(@PathVariable("course_id") int course_id, @PathVariable("user_id") int user_id) {

        ReportCompKey rck = new ReportCompKey(user_id, course_id);
        boolean reportExists = reportsDao.reportExists(rck);
        return reportExists;
    }

    @GetMapping("/")
    public String foo(){
        return "I m from report service";
    }
}
