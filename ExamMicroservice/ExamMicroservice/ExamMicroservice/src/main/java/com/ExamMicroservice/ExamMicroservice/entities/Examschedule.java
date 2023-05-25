package com.ExamMicroservice.ExamMicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Examschedule {
    @Id
    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "levelid",nullable = false)
    private int levelid;
    @Column(name = "courseid",nullable = false)
    private String courseid;

    @Column(name = "useremail",nullable = false)
    private String useremail;

    @Column(name = "examtime",nullable = false)
    private LocalDateTime examtime;

    @Override
    public String toString() {
        return "Examschedule{" +
                "username='" + username + '\'' +
                ", courseid='" + courseid + '\'' +
                ", useremail='" + useremail + '\'' +
                ", examtime=" + examtime +
                '}';
    }
}
