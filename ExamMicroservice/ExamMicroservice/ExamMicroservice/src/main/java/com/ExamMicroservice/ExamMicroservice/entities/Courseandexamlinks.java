package com.ExamMicroservice.ExamMicroservice.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Courseandexamlinks {
    @Id
    @Column(name = "courseid",nullable = false)
    private String courseid;
    @Column(name = "examlink",nullable = false)
    private String examlink;

}
