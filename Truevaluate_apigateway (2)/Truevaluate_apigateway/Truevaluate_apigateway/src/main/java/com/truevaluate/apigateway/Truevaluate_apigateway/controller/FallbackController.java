package com.truevaluate.apigateway.Truevaluate_apigateway.controller;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController

public class FallbackController {


    @GetMapping("/userServiceFallback")
    public List<String> userServiceFallback(){
        return null;
    }

    @GetMapping("/examServiceFallback")
    public List<String> examServiceFallback(){
        return null;
    }

    @GetMapping("/reportServiceFallback")
    public List<String> reportServiceFallback(){
        return null;
    }

    @GetMapping("/authServiceFallback")
    public List<String> contactServiceFallback(){ System.out.println("heeek");
        return null;
    }

    @GetMapping("/addQuestionServiceFallback")
    public List<String> addQuestionServiceFallback(){
        return null;
    }

    @PostMapping("/authServiceFallback")
    public List<String> loginFallback(){
        return null;
    }
}
