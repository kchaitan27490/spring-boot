package com.tibco.providerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tibco.model.ProviderService;
import com.tibco.repository.ProviderServiceRepo;

public class TestController {
	
	@Autowired
	ProviderServiceRepo ps;
	
	@Autowired
	Environment environment;

	@GetMapping("/cabprovider")
	public String backend() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			System.out.println("Sleeping");
		}
		return "The cab details are provider id: 1, provider name: ola, fare=1234";
	}
	
	@GetMapping("/cabprovider/{id}")
	public List<ProviderService> getproviderDetails(@PathVariable int id) {
		List<ProviderService> ls = new ArrayList<ProviderService>();
		Iterable<ProviderService> it = ps.findByproviderid(id);
		for(ProviderService p: it)
		{
			ls.add(p);
		}
		
		return ls;
	}
	
}
