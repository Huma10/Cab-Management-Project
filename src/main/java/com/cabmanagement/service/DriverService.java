package com.cabmanagement.service;

import java.util.List;

import com.cabmanagement.entites.Driver;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.exception.RecordNotFoundException;

public interface DriverService {

	public void add(Driver driver) throws DuplicateRecordException;
	
	public Driver findById(Long id);
	
	public void update(Driver driver, Long id) throws RecordNotFoundException;
	
	public void deleteDriver(Long id);
	
	public List<Driver> getAllDriver();
	
	public Driver findByEmail(String email);
	
	public String generateDriverId();
	
	public List<Driver> findDriversAssinedToCab(Long cabId);
}
