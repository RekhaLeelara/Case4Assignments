package com.edu.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
public class SkeletonApplication {
	
	@GetMapping ("/Hello")
	public String getHello()
	{
		return "This is my first test....yeahoo";
	}

	public static void main(String[] args) {
		SpringApplication.run(SkeletonApplication.class, args);
	}

}
