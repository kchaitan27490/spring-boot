package com.tibco.rideservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.tibco.rideservice.RibbonConfiguration;

@EnableDiscoveryClient
@SpringBootApplication
@RibbonClient(name = "RideService", configuration = RibbonConfiguration.class)
public class RideServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideServiceApplication.class, args);
	}

}
