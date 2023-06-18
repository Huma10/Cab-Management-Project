package com.cabmanagement.driverrepo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cabmanagement.entites.Driver;
import com.cabmanagement.repository.DriverRepository;

// Now, ready to test the repository layer i.e DriverRepository using @DataJpaTest 
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DriverRepositoryTests {

	// First autowire the DriverRepository
	@Autowired
	private DriverRepository driverRepository;
	
	@Test
	public void saveDriver() {
		// used the builder pattern to create an object of Driver Entity
		Driver driver = new Driver();
		driver.setDriverName("abc");
		driver.setEmail("abc@gmail.com");
		driver.setPhoneNo("888888888");
		driverRepository.save(driver);
		assertThat(driver.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getDriverTest() {
		Driver driverInfo = driverRepository.findById(8L).get();
		assertThat(driverInfo.getId().equals(8L));
	}
	@Test
	public void getAllDriverTest() {
		List<Driver> drivers = driverRepository.findAll();
		assertThat(drivers.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateDriverTest() {
		Driver driverInfo = driverRepository.findById(8L).get();
		driverInfo.setDriverName("pqr");
		Driver updatedDriver = driverRepository.save(driverInfo);
		assertThat(updatedDriver.getDriverName()).isEqualTo("pqr");
	}
	
	@Test
	public void deleteDriverTest() {
		Driver driverInfo = driverRepository.findById(8L).get();
		driverRepository.delete(driverInfo);
		Driver driver = null;
		Driver newDriver = driverRepository.findByEmail("abc@gmail.com");
		if(newDriver!=null) {
			driver = newDriver;
		}
		
		assertThat(driver).isNull();
		
	}
}
