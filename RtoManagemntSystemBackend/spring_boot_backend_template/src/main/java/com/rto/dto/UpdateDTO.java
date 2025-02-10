package com.rto.dto;

import java.time.LocalDate;



import com.rto.pojos.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDTO {

	 private String firstName;
		private String lastName;
		private String email;
		private String City;
	    private String State;
		private String address;
		private String Password;
		private int phonenumber;
		
}
