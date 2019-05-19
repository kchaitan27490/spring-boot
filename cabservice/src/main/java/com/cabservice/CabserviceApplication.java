package com.cabservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.Cabs")
public class CabserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabserviceApplication.class, args);
	}

}
