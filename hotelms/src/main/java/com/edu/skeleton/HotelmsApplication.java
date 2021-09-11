package com.edu.skeleton;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.edu.skeleton.model.Hotel;
import com.edu.skeleton.repository.HotelRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@RestController
@EnableHystrix

public class HotelmsApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(HotelmsApplication.class);
	
	
	private HotelRepository userRepository;
	private RestTemplate restTemplate;
	
	public HotelmsApplication(HotelRepository userRepository, RestTemplate restTemplate) {
		this.userRepository = userRepository;
		this.restTemplate = restTemplate;
	}

	@GetMapping("/hello")
	public String getHello() {
		return "Hello Edureka!";
	}
	
	@GetMapping("/hotels")
	public List<Hotel> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/hotels/{id}")
	public Hotel getUserById(@PathVariable Long id) {
		Optional<Hotel> user = userRepository.findById(id);
		if (user.isPresent()) return user.get(); 
		return null;
	}
	
	
	@HystrixCommand(fallbackMethod = "getDataFromFallback",
			commandProperties = {
					@HystrixProperty(
							name = "execution.isolation.thread.timeoutInMilliseconds", 
							value = "3000")})
	@GetMapping("/users/orders")
	public Object getDataFromOrderms() {
		LOGGER.info("calling orderms");
		// httpClient + Ribbon
		Object result = restTemplate.getForObject("http://orderms/orders", Object.class);
		return result;
	}
	@GetMapping("/users/product")
	public Object getDataFromProductms() {
		LOGGER.info("calling orderms");
		// httpClient + Ribbon
		Object result = restTemplate.getForObject("http://prodsearchms/product", Object.class);
		return result;
	}
	 @PutMapping("/hotels/{Hotelid}")
	 Hotel replaceEmployee(@RequestBody Hotel newhotel, @PathVariable Long Hotelid) {
	    
	    return userRepository.findById(Hotelid)
	      .map(hotel -> {
	    	  hotel.setName(newhotel.getName());
	    	  
	    	 // hotel.setRole(newhotel.getRole());
	        return userRepository.save(hotel);
	      })
	      .orElseGet(() -> {
	    	  newhotel.setId(Hotelid);
	        return userRepository.save(newhotel);
	      });
	  }
	 
	 @PostMapping("/hotels/{Hotelid}")
	 Hotel createEmployee(@RequestBody Hotel newhotel, @PathVariable Long Hotelid) {
	    
	    return userRepository.findById(Hotelid)
	      .map(hotel -> {
	    	  hotel.setName(newhotel.getName());
	    	  
	    	 // hotel.setRole(newhotel.getRole());
	        return userRepository.save(hotel);
	      })
	      .orElseGet(() -> {
	    	  newhotel.setId(Hotelid);
	        return userRepository.save(newhotel);
	      });
	  }

	public Object getDataFromFallback() {
		LOGGER.info("calling fallback");
		return "Coming from fallback";
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(HotelmsApplication.class, args);
	}

}
