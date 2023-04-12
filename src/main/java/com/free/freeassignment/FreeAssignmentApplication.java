package com.free.freeassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FreeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeAssignmentApplication.class, args);
	}

}
