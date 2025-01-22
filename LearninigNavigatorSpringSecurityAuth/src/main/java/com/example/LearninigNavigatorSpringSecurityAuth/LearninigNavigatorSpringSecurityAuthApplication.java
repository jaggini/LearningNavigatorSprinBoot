package com.example.LearninigNavigatorSpringSecurityAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.LearninigNavigatorSpringSecurityAuth.model")
@EnableJpaRepositories(basePackages = "com.example.LearninigNavigatorSpringSecurityAuth.repository")
public class LearninigNavigatorSpringSecurityAuthApplication {

    public static void main(String[] args) {

        SpringApplication.run(LearninigNavigatorSpringSecurityAuthApplication.class, args);

    }

}
