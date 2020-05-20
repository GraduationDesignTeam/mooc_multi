package com.mooc.coursenotice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.mooc.client")
@SpringBootApplication
public class CourseNoticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseNoticeApplication.class, args);
	}

}
