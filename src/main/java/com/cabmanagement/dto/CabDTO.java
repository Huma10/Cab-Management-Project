package com.cabmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CabDTO {
	
	private Long id;

	private String cabRegistrationNumber;
	
	private String cabModel;
	
	private String cabColour;
	
	private DriverDTO driver;
	
	private Long driverId;
}
