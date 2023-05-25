package com.results.response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;
@EnableEurekaClient
@SpringBootApplication
public class ResponseApplication {
	@CrossOrigin("/http://localhost:4200")
	public static void main(String[] args) {
		SpringApplication.run(ResponseApplication.class, args);
	}

}
