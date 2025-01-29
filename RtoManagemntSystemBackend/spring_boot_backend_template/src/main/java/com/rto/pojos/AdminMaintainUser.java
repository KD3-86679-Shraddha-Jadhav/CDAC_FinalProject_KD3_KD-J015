//package com.rto.pojos;
//
//
//
//	import java.time.LocalDate;
//
//	import org.springframework.boot.SpringApplication;
//
//	import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//	import jakarta.persistence.Column;
//	import jakarta.persistence.Entity;
//	import jakarta.persistence.EnumType;
//	import jakarta.persistence.Enumerated;
//	import jakarta.persistence.Table;
//	import lombok.Getter;
//	import lombok.NoArgsConstructor;
//	import lombok.Setter;
//	import lombok.ToString;
//
//	@Entity
//	@Table(name = "Registeration")
//	@NoArgsConstructor
//	@Getter
//	@Setter
//	@ToString
//
//	public class AdminMaintainUser extends BaseEntity {
//
//		@Column(name = "first_name", length = 20) // column name , varchar(20)
//		private String firstName;
//		
//		@Column(name = "last_name", length = 20) // column name , varchar(20)
//		private String lastName;
//		
//		@Column(name = "Gender", length = 20)
//		private String gender;
//		
//		private LocalDate dob;
//		
//		@Column(name = "Address", length = 50)
//		private String Address;
//		
//		@Column(length = 25, unique = true) // adds unique constraint
//		private String email;
//		
//		@Column(name = "City", length = 20)
//		private String City;
//		
//		@Column(name = "State", length = 50)
//		private String State;
//		
//		@Column(name = "BloodGroup", length = 50)
//		private String BloodGroup;
//		
//		@Column(name = "PhoneNumber", length = 50)
//		private int phonenumber;
//		
//		@Column(length = 20, nullable = false) // not null constraint
//		private String password;
//		
//		@Enumerated(EnumType.STRING) // create column of type
//		// varchar to store the name of constant
//		@Column(length = 30) // varchar(30)
//		private Role role;
//
//		
//		
//	}
//		
//		
//		
//
//
//
