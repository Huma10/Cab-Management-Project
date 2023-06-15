package com.cabmanagement.service;

import java.util.List;

import com.cabmanagement.entites.Cab;
import com.cabmanagement.exception.DuplicateRecordException;
import com.cabmanagement.exception.RecordNotFoundException;

public interface CabService {

	public void add(Cab Cab) throws DuplicateRecordException;
	
	public Cab findById(Long id);
	
	public void update(Cab Cab, Long id) throws RecordNotFoundException;
	
	public void deleteCab(Long id);
	
	public List<Cab> getAllCab();
}
