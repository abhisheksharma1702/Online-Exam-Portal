package com.question.Adding.service;

import com.question.Adding.entity.Questions;
import com.question.Adding.helper.Helper;
import com.question.Adding.repository.QuestionService;
import com.question.Adding.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    public QuestionService questionService;

    @Autowired
    private QuestionsRepository questionsRepo;

    @Transactional
    public List<Questions> find(int course_id, int level_id, int questionsize) {
        List<Questions> questionsList = questionsRepo.findByCourseIdAndLevelId(course_id, level_id);
        Collections.shuffle(questionsList);
        if (questionsize!=0) {
//       var questionLimit = Integer.valueOf(questionsLis);
            return questionsList.stream().limit(questionsize ).collect(Collectors.toList());
        }
        return questionsList;
    }


    public void save(MultipartFile file)
    {
        try {
            List<Questions> questions = Helper.convertExcelToListOfQuestion(file.getInputStream());
            this.questionsRepo.saveAll(questions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     @Override
    public List<Questions> getallQuestion(){
        return (List<Questions>) this.questionsRepo.findAll();

    }


}
