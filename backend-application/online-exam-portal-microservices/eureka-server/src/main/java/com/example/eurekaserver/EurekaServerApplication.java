package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	//This application is for eureka server. To run the application use http://localhost:8761/
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
