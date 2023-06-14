package com.cabmanagement.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
	@JoinColumn(name = "driver_id")
	private Driver driver;
}
