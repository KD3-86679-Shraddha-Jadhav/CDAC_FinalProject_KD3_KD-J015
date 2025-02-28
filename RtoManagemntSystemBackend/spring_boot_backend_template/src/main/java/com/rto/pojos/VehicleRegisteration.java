package com.rto.pojos;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "VehicleReg")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class VehicleRegisteration extends BaseEntity {

	@Column(name = "first_name", length = 20) // column name , varchar(20)
	private String firstName;
	
	@Column(name = "last_name", length = 20) // column name , varchar(20)
	private String lastName;
	
	
	@Column(length = 25, unique = true) // adds unique constraint
	private String email;
	
	@Column(name = "vehicle_type", length = 20) // column name , varchar(20)
	private String vehicleType;
	
	@Column(name = "Vehicle_Model", length = 20)
	private String vehicleModel;
	
	@Column(name = "LicensePlateNo", length = 20)
	private String licensePlateNo;
	
	@Column(name = "Address", length = 50) // column name , varchar(20)
	private String Address;
	
	@Column(name = "City", length = 20) // column name , varchar(20)
	private String City;

	public VehicleRegisteration(String firstName, String lastName, String email, String vehicleType, String vehicleModel,
			String licensePlateNo, String address, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.licensePlateNo = licensePlateNo;
		Address = address;
		City = city;
	}
	
	
	
	
	
}
	
	
	

