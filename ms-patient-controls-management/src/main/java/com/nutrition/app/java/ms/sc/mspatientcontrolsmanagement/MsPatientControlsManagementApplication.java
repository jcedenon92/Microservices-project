package com.nutrition.app.java.ms.sc.mspatientcontrolsmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsPatientControlsManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPatientControlsManagementApplication.class, args);
    }

}
