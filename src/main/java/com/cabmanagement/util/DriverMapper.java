package com.cabmanagement.util;

import com.cabmanagement.dto.DriverDTO;
import com.cabmanagement.entites.Driver;

public class DriverMapper {

	public static DriverDTO entityToDTO(Driver driver) {

		DriverDTO driverDTO = new DriverDTO();
		if (driver == null) {
			return driverDTO;
		}
		driverDTO.setId(driver.getId());
		driverDTO.setDriverIdNumber(driver.getDriverIdNumber());
		driverDTO.setDriverName(driver.getDriverName());
		driverDTO.setEmail(driver.getEmail());
		driverDTO.setPhoneNo(driver.getPhoneNo());
		return driverDTO;
	}

	public static Driver DTOToEntity(DriverDTO driverDTO) {

		Driver driver = new Driver();
		if (driverDTO == null) {
			return driver;
		}
		driver.setId(driverDTO.getId());
		driver.setDriverIdNumber(driverDTO.getDriverIdNumber());
		driver.setDriverName(driverDTO.getDriverName());
		driver.setEmail(driverDTO.getEmail());
		driver.setPhoneNo(driverDTO.getPhoneNo());
		return driver;
	}
}
