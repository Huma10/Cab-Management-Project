package com.cabmanagement.cabrepo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cabmanagement.entites.Cab;
import com.cabmanagement.repository.CabRepository;

// Now, ready to test the repository layer i.e CabRepository using @DataJpaTest 
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CabRepositoryTests {

	// First autowire the CabRepository
	@Autowired
	private CabRepository cabRepository;
	
	@Test
	public void saveCab() {
		// create an object of Cab Entity
		Cab cab = new Cab();
		cab.setCabRegistrationNumber("123558");
		cab.setCabModel("testmodel");
		cab.setCabColour("red");
		cabRepository.save(cab);
		assertThat(cab.getId()).isGreaterThan(0);
	}
	
	@Test
	public void getCabTest() {
		Cab cabInfo = cabRepository.findById(3L).get();
		assertThat(cabInfo.getId().equals(3L));
	}
	@Test
	public void getAllCabTest() {
		List<Cab> cabs = cabRepository.findAll();
		assertThat(cabs.size()).isGreaterThan(0);
	}
	
	@Test
	public void updateCabTest() {
		Cab cabInfo = cabRepository.findById(3L).get();
		cabInfo.setCabModel("pqr");
		Cab updatedCab = cabRepository.save(cabInfo);
		assertThat(updatedCab.getCabModel()).isEqualTo("pqr");
	}

}
