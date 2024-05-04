package com.questionsservice.repository;

import com.questionsservice.entity.Questions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends CrudRepository<Questions,Integer> {
    public List<Questions> findByCourseIdAndLevelId(int course_id, int level_id);

}