package com.Cabs;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cabservice.Cab;

public interface CabsRepository extends CrudRepository<Cab, Integer> {

	List<Cab> findBySource(String source);

	List<Cab> findByDriverName(String driverName);

	void deleteByDriverName(String driverName);

//	@Query("select c from cabservice c where c.driverName like %:driverName%")
//	public void deleteByDriverName(@Param("driverName") String driverName);

}
