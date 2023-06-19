package com.cabmanagement.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "cabs")
	private  List<Driver> drivers = new ArrayList<>();
}
