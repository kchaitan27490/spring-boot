package com.tibco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

	@GetMapping("/apitest")
	public String testMethod() {
		return restTemplate.getForObject("http://providerservice/cabprovider", String.class);
	}

	@GetMapping("/all/{riderid}")
	public String getCabProvider(@PathVariable int riderid) {
		return restTemplate.getForObject("http://providerservice/cabprovider/" + riderid, String.class);
	}
}
