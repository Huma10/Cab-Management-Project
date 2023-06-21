package com.cabmanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.cabmanagement.entites.Cab;
import com.cabmanagement.entites.Driver;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.exception.RecordNotFoundException;
import com.cabmanagement.repository.CabRepository;
import com.cabmanagement.repository.DriverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
	
	private final DriverRepository driverRepository;
	
	private final CabRepository cabRepository;
	
	private Logger log = Logger.getLogger(DriverServiceImpl.class.getName());

	@Override
	public void add(Driver driver) throws DuplicateRecordException {
		log.info("add method of DriverServiceImpl started");
		Driver driverExists = findByEmail(driver.getEmail());
		if(driverExists!=null)
			throw new DuplicateRecordException("Driver with "+driver.getEmail()+" already exist");
		driver.setDriverIdNumber("CAB -"+generateDriverId());
		driverRepository.save(driver);
		log.info("add method of DriverServiceImpl ended");
	}

	@Override
	public Driver findById(Long id) {
		log.info("findById method of DriverServiceImpl started");
		log.info("findById method of DriverServiceImpl ended");
		return driverRepository.findById(id).get();
	}

	@Override
	public void update(Driver driver, Long id) throws RecordNotFoundException {
		log.info("update method of DriverServiceImpl started");
		Optional<Driver> driverExist = driverRepository.findById(id);
		System.out.println(driver.getDriverIdNumber());
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
		log.info("update method of DriverServiceImpl ended");
	}

	@Override
	public void deleteDriver(Long id) {
		log.info("delete method of DriverServiceImpl started");
		driverRepository.deleteById(id);
		log.info("delete method of DriverServiceImpl ended");
	}

	@Override
	public List<Driver> getAllDriver() {
		log.info("getAllDriver method of DriverServiceImpl started");
		log.info("getAllDriver method of DriverServiceImpl ended");
		return driverRepository.findAll();
	}

	@Override
	public Driver findByEmail(String email) {
		log.info("findByEmail method of DriverServiceImpl started");
		log.info("findByEmail method of DriverServiceImpl ended");
		return driverRepository.findByEmail(email);
	}

	@Override
	public String generateDriverId() {
		log.info("generateDriverId method of DriverServiceImpl started");
		if(driverRepository.generateDriverIdNumber() == null) {
			return "1";
		}
		int driverIdNumber = Integer.parseInt(driverRepository.generateDriverIdNumber().substring(5)) + 1;
		log.info("generateDriverId method of DriverServiceImpl ended");
		return String.valueOf(driverIdNumber);
		
	}

	@Override
	public void assignCabToDriver(Long driverId, Long cabId) {
		List<Cab> cabs = null;
		Driver driver = driverRepository.findById(driverId).get();
		Cab cab = cabRepository.findById(cabId).get();		
		cabs = driver.getCabs();
		
		cabs.add(cab);
		
		driver.setCabs(cabs);
		
		driverRepository.save(driver);
		
		
	}

}
