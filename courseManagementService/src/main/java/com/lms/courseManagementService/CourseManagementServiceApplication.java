package com.lms.courseManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lms.courseManagementService.repository")
public class CourseManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementServiceApplication.class, args);
	}

}
