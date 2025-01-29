package com.rto.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ApplyForLLRespDTO extends BaseDTO{

	private String fullName;
    private LocalDate dob;
    private String bloodgroup;
    private String address;
    private Long phonenumber;
    private String email;
    private String vehicleDetails;
    private String role; // 
	
}
