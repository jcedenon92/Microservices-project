package com.nutrition.app.java.ms.sc.msusercustomermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsUserCustomerManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsUserCustomerManagementApplication.class, args);
    }

}
