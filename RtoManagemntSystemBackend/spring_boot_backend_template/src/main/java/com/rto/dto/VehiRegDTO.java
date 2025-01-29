package com.rto.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehiRegDTO {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String vehicleType;

	private String vehicleModel;

	private String licensePlateNo;
	
	private String Address;

	private String City;
}
