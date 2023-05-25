package com.ExamMicroservice.ExamMicroservice.services;


import com.ExamMicroservice.ExamMicroservice.entities.Courseandexamlinks;
import com.ExamMicroservice.ExamMicroservice.entities.Examschedule;
import com.ExamMicroservice.ExamMicroservice.entities.Proctor;
import com.ExamMicroservice.ExamMicroservice.repositories.ProctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class ProctorMethods {
    @Autowired
    private ProctorRepository proctorRepository;
//    @Autowired
//    private CourseandexamlinkRepository courseandexamlinkRepository;
    @Autowired
    private EmailSenderService emailSenderService;
    LocalDateTime examtime;
    LocalDateTime mailtime;
    int levelid;
    String useremail;
    String courseid;
    String examLink="www.google.com";
    private List<Courseandexamlinks> courseandexamlinksList;
    List<Proctor> proctorList=new ArrayList<Proctor>();
    List<Proctor> availableProctorList=new LinkedList<>();
    private Proctor liveProctor=new Proctor();
    public void getProctors()
    {
        // finding all the proctors in Proctor table
        proctorList=proctorRepository.findAll();
        for (Proctor p : proctorList) {
            if (p.getProctorAvailable()==1) {
                availableProctorList.add(p);
            }
        }
        Random rand = new Random();
        if(availableProctorList.size()>0){
            liveProctor = availableProctorList.get(rand.nextInt(availableProctorList.size()));
            System.out.println("chosen proctor is = "+liveProctor.toString());
            liveProctor.setProctorAvailable(0);
            availableProctorList.remove(liveProctor);
            proctorRepository.save(liveProctor);
        }
        else {
            System.out.println("No proctors are available");
        }
    }
    public void getExamScheduled(Examschedule examschedule, int questionsize) {
        examtime = examschedule.getExamtime();
        useremail = examschedule.getUseremail();
        courseid = examschedule.getCourseid();
        levelid = examschedule.getLevelid();
        examLink = "http://localhost:4200/candidate_exam_login/"+courseid + "/" +levelid + "/" + questionsize;
        System.out.println(examschedule.toString() + "link=" + examLink);
        getProctors();
        sendEmail();
    }
//    }
public void sendEmail(){
    String emailBodyUser="Hi \nThanks for registering exam on True Evaluate.\nClick the below link to proceed to the exam.\n"+examLink+"\n\nThanks, and Regards\nTrue-Evaluate";
    String emailBodyProctor="Hi \nYou are invited to proctor an exam on True Evaluate.\nClick the below link to proceed to the exam.\n"+examLink+"\n\nThanks, and Regards\nTrue-Evaluate";
    String emailSubjectUser="True-Evaluate Exam Link";
    String emailSubjectProctor="True-Evaluate Exam proctoring Link";
    //finding 30 minutes before exam time
    mailtime =examtime.minusMinutes(30);
    System.out.println(mailtime);
    // scheduling to send an email at specific time
    Date temp=java.util.Date.from(mailtime.atZone(ZoneId.systemDefault()).toInstant());
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("mail function is working examtime="+ mailtime);
            emailSenderService.sendSimpleEmail(useremail,emailSubjectUser,emailBodyUser);
            emailSenderService.sendSimpleEmail(liveProctor.getProctorEmail(), emailSubjectProctor,emailBodyProctor);
        }
    }, temp);
    //making proctor available after 3 hrs
    mailtime = mailtime.plusMinutes(30);
    mailtime = mailtime.plusHours(3);
    temp=java.util.Date.from(mailtime.atZone(ZoneId.systemDefault()).toInstant());
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            liveProctor.setProctorAvailable(1);
            proctorRepository.save(liveProctor);
            availableProctorList.add(liveProctor);
        }
    }, temp);
}

    public void createSupportTicket(String name, String email, String message){
        String emailBody="Hi " + name + ",\n\nWe got your message : '" + message + "'\nOur Support team is working. We'll get back to you ASAP." + "\n\nThanks & Regards,\nOEM Support Team";
        String emailSubject="Support Ticket Generate";
        emailSenderService.sendSimpleEmail(email,emailSubject,emailBody);
    }
}
