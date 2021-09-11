		package com.edu.skeleton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.skeleton.filters.MyPostFilter;
import com.edu.skeleton.filters.MyPreFilter;

@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {
	
	@Bean
	public MyPreFilter getPreFilter() {
		return new MyPreFilter();
	}
	
	@Bean
	public MyPostFilter getPostFilter() {
		return new MyPostFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
