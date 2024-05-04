package com.examservice.controllers;
import com.examservice.entities.ContactSupport;
import com.examservice.entities.Examschedule;
import com.examservice.repositories.ExamscheduleRepository;
import com.examservice.services.ProctorMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/schedule/examschedule")
public class ExamscheduleController {
    @Autowired
    private ExamscheduleRepository examscheduleRepository;
    @Autowired private ProctorMethods pm;

    @PostMapping("/{questionsize}")
    public Examschedule saveData(@RequestBody Examschedule x, @PathVariable("questionsize") int questionsize)
    {
        System.out.println(x.getExamtime());
        examscheduleRepository.save(x);
        pm.getExamScheduled(x, questionsize);
        return x;
    }
//    @GetMapping("/userName/{userName}")
//    public int getCourseId(@PathVariable String userName)
//    {
//        System.out.println("UserName" + userName);
//        Examschedule examschedule = examscheduleRepository.findByUsername(userName);
//        int courseId = 0;
//        if(!ObjectUtils.isEmpty(examschedule))
//            courseId = Integer.parseInt(examschedule.getCourseid());
//
//        System.out.println("Course id " + courseId);
//        return courseId;
//    }
    @GetMapping("/")
    public String foo(){
        return "I m from Schedule-exam service";
    }

    @PostMapping("/support")
    public void support(@RequestBody ContactSupport cs){
        System.out.println("Hiiiiiiiiiiiiiiiii");
        pm.createSupportTicket(cs.getFull_name(), cs.getEmail(), cs.getMessage());
    }

}
