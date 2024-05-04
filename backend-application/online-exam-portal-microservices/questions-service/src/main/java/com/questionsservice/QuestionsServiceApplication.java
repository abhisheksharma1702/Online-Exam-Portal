package com.questionsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;
@EnableEurekaClient
@SpringBootApplication
public class QuestionsServiceApplication {

	@CrossOrigin(origins="http://localhost:4200")
	public static void main(String[] args) {
		SpringApplication.run(QuestionsServiceApplication.class, args);
	}

}
