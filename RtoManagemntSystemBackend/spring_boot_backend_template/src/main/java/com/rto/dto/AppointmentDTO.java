package com.rto.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AppointmentDTO {

	private String firstName;
    private String lastName;
	private LocalDate dob;
	private String Address;
	private String City;
	private String State;
	private String pincode;
	private String country;
	
	public AppointmentDTO(String firstName, String lastName, LocalDate dob, String address, String city, String state,
			String pincode, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		Address = address;
		City = city;
		State = state;
		this.pincode = pincode;
		this.country = country;
	}
	
	
}
