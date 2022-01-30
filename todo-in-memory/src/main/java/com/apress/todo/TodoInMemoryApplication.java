package com.apress.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TodoInMemoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoInMemoryApplication.class, args);
	}
}