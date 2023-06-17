package com.cabmanagement;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cabmanagement.repository.DriverRepository;
import com.cabmanagement.service.DriverService;

@SpringBootTest
class CabManagementProjectApplicationTests {

	private DriverService driverService;	
	
	public CabManagementProjectApplicationTests(DriverService driverService) {
		super();
		this.driverService = driverService;
	}
	@MockBean
	private DriverRepository driverRepository;
	
	
}
