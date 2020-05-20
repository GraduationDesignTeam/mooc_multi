package com.mooc.courseware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CourseWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseWareApplication.class, args);
	}

}
