package com.cabmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cabmanagement.entites.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

	Driver findByEmail(String email);
	
	@Query(value = "SELECT driver_id_number FROM Driver order by id desc LIMIT 1", nativeQuery = true)
	String generateDriverIdNumber();
	
	List<Driver> findDriversByCabsId(Long cabId);
}
