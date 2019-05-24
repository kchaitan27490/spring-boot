package com.tibco.providerservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tibco.model.ProviderService;
import com.tibco.repository.ProviderServiceRepo;

public class ProviderController {
	
	@Autowired
	ProviderServiceRepo psrepo;
	
	@Autowired
	Environment environment;

//	@GetMapping("/cabprovider")
//	public String backend() {
//		try {
//			Thread.sleep(300);
//		} catch (InterruptedException e) {
//			System.out.println("Sleeping");
//		}
//		return "The cab details are provider id: 1, provider name: ola, fare=1234";
//	}
//	
	@GetMapping("/cabprovider/{id}")
	public List<ProviderService> getproviderDetails(@PathVariable int id) {
		List<ProviderService> ls = new ArrayList<ProviderService>();
		Iterable<ProviderService> it = psrepo.findByproviderid(id);
		for(ProviderService p: it)
		{
			ls.add(p);
		}
		
		return ls;
	}
	
	@PostMapping("/cabprovider/add")
	public ProviderService AddProviderDetails(@RequestBody ProviderService ps) {
		ps = psrepo.save(ps);
		return ps;
	}
	
	@PostMapping("/cabprovider/addall")
	public Iterable<ProviderService> AddAllProviderDetails(@RequestBody Iterable<ProviderService> ps) {
		psrepo.saveAll(ps);
		return ps;
	}
	
}
