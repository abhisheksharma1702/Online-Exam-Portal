package com.ExamMicroservice.ExamMicroservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Value("${spring.mail.username}") private String sender;
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,String subject, String body)
    {
        SimpleMailMessage message=new SimpleMailMessage();

        message.setFrom(sender);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("mail sent to "+toEmail);
    }

}
