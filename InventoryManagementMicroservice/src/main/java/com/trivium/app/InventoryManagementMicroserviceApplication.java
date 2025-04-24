package com.trivium.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.trivium")
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.trivium.repo")
@EntityScan(basePackages = "com.trivium.entity")
public class InventoryManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementMicroserviceApplication.class, args);
		System.out.println("Inventory microservice has been stareted...");
	}

}
