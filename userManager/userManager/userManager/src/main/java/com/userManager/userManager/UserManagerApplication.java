package com.userManager.userManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(UserManagerApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {



		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Project Running");
	}
}
