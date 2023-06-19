package com.cabmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabmanagement.entites.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long> {

	List<Cab> findCabsByDriversId(Long driverId);
}
