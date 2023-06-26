package com.cabmanagement.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cab")
@Setter
@Getter
public class Cab {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cab_registration_number", length = 255)
	private String cabRegistrationNumber;
	
	@Column(name = "cab_model", length = 255)
	private String cabModel;
	
	@Column(name = "cab_colour", length = 255)
	private String cabColour;
	
	@ManyToOne
	@JoinColumn(name = "driver")
	private Driver driver;
	
	private Long driverId;
}
