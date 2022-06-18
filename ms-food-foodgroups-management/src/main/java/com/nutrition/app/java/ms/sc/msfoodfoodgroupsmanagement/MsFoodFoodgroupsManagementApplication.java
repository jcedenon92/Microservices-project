package com.nutrition.app.java.ms.sc.msfoodfoodgroupsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsFoodFoodgroupsManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsFoodFoodgroupsManagementApplication.class, args);
	}

}
