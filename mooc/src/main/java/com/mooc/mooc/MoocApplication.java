package com.mooc.mooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MoocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoocApplication.class, args);
	}

}
