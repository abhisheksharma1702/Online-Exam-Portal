package com.questionsservice.service;
import com.questionsservice.entity.Questions;

public interface AdminService {

    public Questions insert(Questions question);

    public void delete(int id);




}
