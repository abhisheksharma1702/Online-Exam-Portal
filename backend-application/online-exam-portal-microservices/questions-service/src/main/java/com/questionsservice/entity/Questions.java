package com.questionsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "questions")
public class Questions {

    @Id
    @GenericGenerator(name="id" , strategy="increment")
    @GeneratedValue(generator="id")
    private int question_id;
    @Column(name="course_id")
    private int courseId;
    @Column(name="level_id")
    private int levelId;
    @Column(length=200)
    private String question;
    @Column(length=200)
    private String option_1;
    @Column(length=200)
    private String option_2;
    @Column(length=200)
    private String option_3;
    @Column(length=200)
    private String option_4;
    @Column(length=200)
    private String correct_option;


    @Override
    public String toString() {
        return "Questions [question_id=" + question_id + ", course_id=" + courseId + ", level_id=" + levelId
                + ", question=" + question + ", option_1=" + option_1 + ", option_2=" + option_2 + ", option_3="
                + option_3 + ", option_4=" + option_4 + ", correct_option=" + correct_option + "]";
    }

}
