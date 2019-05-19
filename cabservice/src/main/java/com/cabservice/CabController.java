package com.cabservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Cabs.CabsRepository;

@RestController
public class CabController {
	
	@Autowired
	private CabsRepository cabsrepo;
	
	@GetMapping("/all")
	public List<Cab> getRideDetails(){
		List<Cab> cabs = new ArrayList<Cab>(); 
		Iterable<Cab> it = cabsrepo.findAll();
		for(Cab c : it) 
		{
			cabs.add(c);
		}
		return cabs;
	}
	
	@GetMapping("/all/source/{source}")
	public List<Cab> getDetailsFromDest(@PathVariable String source){
		List<Cab> cabs = new ArrayList<Cab>();
		Iterable<Cab> it = cabsrepo.findBySource(source);
		for(Cab c: it)
		{
			cabs.add(c);
		}
		return cabs;
	}
	
	@GetMapping("/all/driver/{driverName}")
	public List<Cab> getDetailsByDriver(@PathVariable String driverName){
		List<Cab> cabs = new ArrayList<Cab>();
		Iterable<Cab> it = cabsrepo.findByDriverName(driverName);
		for(Cab c: it)
		{
			cabs.add(c);
		}
		return cabs;
	}
	
	@PostMapping("/add")
	public Cab addCabData(@RequestBody Cab c)	{
		c = cabsrepo.save(c);
		return c;
				
	}
	
	@PostMapping("/addall")
	public Iterable<Cab> addAllCabs(@RequestBody Iterable<Cab> c) {
		cabsrepo.saveAll(c);		
		return c;
	}
	
	@PutMapping("/update")
	public Cab updateCabData(@RequestBody Cab c) {
		c = cabsrepo.save(c);
		return c;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		cabsrepo.deleteById(id);
		System.out.println("The id: " + id + "has been deleted");		
	}
	
	@DeleteMapping("/delete/driver/{driverName}")
	public void deleteByCabDriver(@PathVariable String driverName) {
		cabsrepo.deleteByDriverName(driverName);
	}
	
	@DeleteMapping("/delete/all")
	public void deleteCabDetails() {
		cabsrepo.deleteAll();
		System.out.println("All cab details are deleted. Enter cab details to view");
	}

	public CabsRepository getCabsrepo() {
		return cabsrepo;
	}

	public void setCabsrepo(CabsRepository cabsrepo) {
		this.cabsrepo = cabsrepo;
	}
	

}
