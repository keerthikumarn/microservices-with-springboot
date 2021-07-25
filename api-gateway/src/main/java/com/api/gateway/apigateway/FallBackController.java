package com.api.gateway.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FallBackController {
	
	@GetMapping("/studentServiceFallBack")
	@HystrixCommand
	public String studentServiceFallBack() {
		return "User service seems to be down. Kindly try after some time !!";
	}
	
	@GetMapping("/courseServiceFallBack")
	@HystrixCommand
	public String courseServiceFallBack() {
		return "course service seems to be down. Kindly try after some time !!";
	}

}
