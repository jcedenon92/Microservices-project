package com.nutrition.app.java.ms.sc.msvaccinesdosemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsVaccinesDoseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVaccinesDoseManagementApplication.class, args);
	}

}
