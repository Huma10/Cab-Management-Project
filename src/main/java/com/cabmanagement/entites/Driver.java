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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "driver")
@Setter
@Getter
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "driver_name", length = 255)
	private String driverName;
	
	@Column(name = "driver_id_number", length = 255)
	private String driverIdNumber;
	
	@Column(name = "email", length = 255)
	private String email;
	
	@Column(name = "phone_no", length = 255)
	private String phoneNo;
	
	@Transient
	private Long cabId;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "driver_cabs", joinColumns = {@JoinColumn(name="driver_id")}, inverseJoinColumns = {@JoinColumn(name="cab_id")})
	private List<Cab> cabs = new ArrayList<>();
	
}
