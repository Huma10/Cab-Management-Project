package com.cabmanagement.service;

import java.util.List;
import java.util.Optional;

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
public class CabServiceImpl implements CabService {
	
	private final CabRepository cabRepository;
	
	private final DriverRepository driverRepository;

	@Override
	public void add(Cab cab) throws DuplicateRecordException {
		cabRepository.save(cab);		
	}

	@Override
	public Cab findById(Long id) {
		return cabRepository.findById(id).get();
	}

	@Override
	public void update(Cab cab, Long id) throws RecordNotFoundException {
		Optional<Cab> cabExist = cabRepository.findById(id);
		if(!cabExist.isPresent()) {
			throw new RecordNotFoundException("Cab does not exists");	
		} else {
			Cab newCab = new Cab();
			newCab.setId(cab.getId());
			newCab.setCabColour(cab.getCabColour());
			newCab.setCabModel(cab.getCabModel());
			newCab.setCabRegistrationNumber(cab.getCabRegistrationNumber());
			cabRepository.save(newCab);
		}
		
	}

	@Override
	public void deleteCab(Long id) {
		cabRepository.deleteById(id);
	}

	@Override
	public List<Cab> getAllCab() {
		return cabRepository.findAll();
	}
	
	@Override
	public void assignDriversToCab(Long driverId, Long cabId) {
		Cab cab = cabRepository.findById(cabId).get();
		Driver driver = driverRepository.findById(driverId).get();		
		cab.setDriverId(driverId);
		cab.setDriver(driver);
		cabRepository.save(cab);		
		
	}

}
