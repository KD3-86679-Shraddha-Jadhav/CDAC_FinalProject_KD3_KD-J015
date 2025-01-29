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

@Entity
@Table(name = "Login")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Login extends BaseEntity{

	@Column(name = "email",length = 50)
	private String email;
	
	@Column(length = 20, nullable = false) // not null constraint
	private String password;
	
	@Enumerated(EnumType.STRING) // create column of type
	// varchar to store the name of constant
	@Column(length = 30) // varchar(30)
	private Role role;

	public Login(String email, String password, Role role) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
	}

	
	
	
}
