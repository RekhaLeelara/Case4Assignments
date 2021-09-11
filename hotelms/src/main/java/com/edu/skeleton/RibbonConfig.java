package com.edu.skeleton;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RibbonConfig {
	@Bean
	@LoadBalanced //Ribbon (Client-side Load Balancer)
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
}
