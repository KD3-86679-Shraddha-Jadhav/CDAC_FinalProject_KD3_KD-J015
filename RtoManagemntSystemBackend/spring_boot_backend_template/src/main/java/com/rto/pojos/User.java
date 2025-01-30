package com.rto.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "User")
@NoArgsConstructor
@Getter
@Setter
@ToString

public class User extends BaseEntity {

	@Column(name = "first_name", length = 20) // column name , varchar(20)
	private String firstName;
	
	@Column(name = "last_name", length = 20) // column name , varchar(20)
	private String lastName;
	
	@Column(name = "Gender", length = 20)
	private String gender;
	
	private LocalDate dob;
	
	@Column(name = "Address", length = 50)
	private String Address;
	
	@Column(length = 25, unique = true) // adds unique constraint
	private String email;
	
	@Column(name = "City", length = 20)
	private String City;
	
	@Column(name = "State", length = 50)
	private String State;
	
	@Column(name = "BloodGroup", length = 50)
	private String BloodGroup;
	
	@Column(name = "PhoneNumber", length = 50)
	private int phonenumber;
	
	@Column(length = 20, nullable = false) // not null constraint
	private String password;
	
	@Enumerated(EnumType.STRING) // create column of type
	// varchar to store the name of constant
	@Column(length = 30) // varchar(30)
	private Role role;
	
	@Transient
	@OneToMany(mappedBy = "user")
	private List<VehicleRegisteration> vehReg;
	
	@Transient
	@OneToOne
	@JoinColumn(name="exam_appl_id")
	private ExamApplication examApp;

	public User(String firstName, String lastName, String gender, LocalDate dob, String address, String email,
			String city, String state, String bloodGroup, int phonenumber, String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		Address = address;
		this.email = email;
		City = city;
		State = state;
		BloodGroup = bloodGroup;
		this.phonenumber = phonenumber;
		this.password = password;
		this.role = role;
	}
	
}
	
	
	

