package com.cabmanagement.dto;

import java.util.List;

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
	
	private Long cabId;
}
