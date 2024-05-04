package com.questionsservice.controller;

import com.questionsservice.entity.Questions;
import com.questionsservice.helper.Helper;
import com.questionsservice.service.AdminService;
import com.questionsservice.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/add/admin-restapi")
@CrossOrigin("*")

public class Admin {

    @Autowired
    private AdminService adminService;

    @Autowired
    private QuestionServiceImpl qs;



    @RequestMapping(value="/add_question",method= RequestMethod.POST)
    public Questions insert(@RequestBody Questions question) {
        return adminService.insert(question);
    }

    @DeleteMapping("/remove_question/{id}")
    public void delete(@PathVariable int id) {

        adminService.delete(id);
    }

    @GetMapping("/questions/{course_id}/{level_id}/{questionsize}")
    public List<Questions> getQuestions(@PathVariable("course_id") int course_id, @PathVariable("level_id") int level_id,
                                        @PathVariable("questionsize") int questionsize){

        return qs.find(course_id, level_id, questionsize);
    }




    @PostMapping("/question/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file)
    {
        if(Helper.checkExcelFormat(file))
        {
            //true

            this.qs.save(file);
            return ResponseEntity.ok(Map.of("message","File is uploaded and saved to DB"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLEASE UPLOAD EXCEL FILE IN PROPER FORMAT");
    }

    @GetMapping("/questions")
    public List<Questions> getAllQuestion()
    {
        return this.qs.getallQuestion();
    }





    @GetMapping("/")
    public String hello(){
        return "I am from adding-questions Service";
    }
}
