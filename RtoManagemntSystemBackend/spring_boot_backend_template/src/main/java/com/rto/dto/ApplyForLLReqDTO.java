package com.rto.dto;

import java.time.LocalDate;

import com.rto.pojos.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyForLLReqDTO {

	
	    private String fullName;
	    private LocalDate dob;
	    private String bloodgroup;
	    private String address;
	    private Long phonenumber;
	    private String email;
	    private String vehicleDetails;
	    private Role role;
}
