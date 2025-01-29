package com.rto.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity // mandatory class level annotation for hibernate , to specify
//following class represents DB entity
@Table(name = "Licen_Regist") // to specify name of the table
@NoArgsConstructor
@Getter
@Setter
//@ToString(callSuper = true,exclude = {"userAddress","password","image"} )
@ToString
public class ApplyForLL extends BaseEntity {

	@Column(name = "FullName", length = 20) // column name , varchar(20)
	private String fullName;
	
	@Column(name = "DateofBirth")
	private LocalDate dob;
	
	@Column( name="bloodgroup",length = 25) 
	private String bloodgroup;
	
	@Column(name = "Address", length = 20) // column name , varchar(20)
	private String Address;
	
	@Column(name = "PhoneNumber",length = 25) 
	private Long phonenumber;
	
	@Column(name = "Email", length = 25) 
	private String email;
	
	@Column( name="vehicleDetails",length = 20 ) 
	private String VehicleDetails ;
	
	
	@Enumerated(EnumType.STRING) // create column of type
	// varchar to store the name of constant
	@Column( name="role",length = 30) // varchar(30)
	private Role role;

	
//	@OneToOne(mappedBy = "learningLicense", cascade = CascadeType.ALL)//pk
//	private ApplyForDL drivingLicense;

	

	public ApplyForLL(String firstName, LocalDate dob, String bloodgroup, String address, Long phonenumber,
			String email, String vehicleDetails, Role role) {
		super();
		this.fullName = firstName;
		this.dob = dob;
		bloodgroup = bloodgroup;
		Address = address;
		this.phonenumber = phonenumber;
		this.email = email;
		VehicleDetails = vehicleDetails;
		this.role = role;
	}
	
	
	
} 