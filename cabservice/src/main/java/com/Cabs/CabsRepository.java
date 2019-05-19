package com.Cabs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.cabservice.Cab;

public interface CabsRepository extends CrudRepository<Cab, Integer> {

	List<Cab> findBySource(String source);

	List<Cab> findByDriverName(String driverName);

	@Transactional
	void deleteByDriverName(String driverName);

//	@Query("select c from cabservice c where c.driverName like %:driverName%")
//	public void deleteByDriverName(@Param("driverName") String driverName);

}
