package com.cabmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverDTO {
	
	private Long id;
	
	private String driverName;
	
	private String driverIdNumber;	
	
	private String email;	
	
	private String phoneNo;
}
