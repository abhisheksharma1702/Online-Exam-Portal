package com.question.Adding.repository;

import com.question.Adding.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface QuestionService {


    public List<Questions> getallQuestion();


}
