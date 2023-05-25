package com.results.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmitResponse {
    private int courseId;
    private int levelId;
    private int userId;
    private int marks;
    private int totalQuestions;
}
