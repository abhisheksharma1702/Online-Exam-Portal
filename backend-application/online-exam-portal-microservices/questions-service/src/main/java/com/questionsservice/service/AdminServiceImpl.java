package com.questionsservice.service;

import com.questionsservice.entity.Questions;
import com.questionsservice.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private QuestionsRepository quesRepo;

    @Override
    public Questions insert(Questions question) {
        return quesRepo.save(question);
    }

    @Override
    public void delete(int id) {
        quesRepo.deleteById(id);
    }
}
