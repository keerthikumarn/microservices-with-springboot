package com.myservice.registry.myserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyserviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyserviceRegistryApplication.class, args);
	}

}
