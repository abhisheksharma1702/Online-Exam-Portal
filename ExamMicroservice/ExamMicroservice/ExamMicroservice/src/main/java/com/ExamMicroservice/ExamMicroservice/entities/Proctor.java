package com.ExamMicroservice.ExamMicroservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "proctorId",nullable = false)
    private int proctorId;
    @Column(name="proctorEmail")
    private String proctorEmail;
    @Column(name="proctorAvailable")
    private int proctorAvailable;

    @Override
    public String toString() {
        return "Proctor{" +
                "proctorId=" + proctorId +
                ", proctorEmail='" + proctorEmail + '\'' +
                ", proctorAvailable=" + proctorAvailable +
                '}';
    }
}
