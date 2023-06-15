package com.cabmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cabmanagement.entites.Driver;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.exception.RecordNotFoundException;
import com.cabmanagement.repository.DriverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
	
	private final DriverRepository driverRepository;

	@Override
	public void add(Driver driver) throws DuplicateRecordException {
		Driver driverExists = findByEmail(driver.getEmail());
		if(driverExists!=null)
			throw new DuplicateRecordException("Driver with "+driver.getEmail()+" already exist");
		driverRepository.save(driver);		
	}

	@Override
	public Driver findById(Long id) {
		return driverRepository.findById(id).get();
	}

	@Override
	public void update(Driver driver, Long id) throws RecordNotFoundException {
		Optional<Driver> driverExist = driverRepository.findById(id);
		if(!driverExist.isPresent()) {
			throw new RecordNotFoundException("Driver does not exists");	
		} else {
			Driver newDriver = new Driver();
			newDriver.setId(driver.getId());
			newDriver.setDriverIdNumber(driver.getDriverIdNumber());
			newDriver.setDriverName(driver.getDriverName());
			newDriver.setEmail(driver.getEmail());
			newDriver.setPhoneNo(driver.getPhoneNo());
			driverRepository.save(newDriver);
		}
		
	}

	@Override
	public void deleteDriver(Long id) {
		driverRepository.deleteById(id);
	}

	@Override
	public List<Driver> getAllDriver() {
		return driverRepository.findAll();
	}

	@Override
	public Driver findByEmail(String email) {
		return driverRepository.findByEmail(email);
	}

}
