package com.tibco.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tibco.model.ProviderService;

public interface ProviderServiceRepo extends CrudRepository<ProviderService, Integer>{
	
	List<ProviderService> findByproviderid(int providerid);

}
