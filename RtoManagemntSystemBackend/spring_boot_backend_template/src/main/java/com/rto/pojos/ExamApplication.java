package com.rto.pojos;

import java.time.LocalDate;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="examApplication")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExamApplication extends BaseEntity{

//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate primary key
//	    private Long id;  // Primary key field
	
	@Column(nullable = false)
	private LocalDate dateOfAppl;
	@Enumerated(EnumType.STRING)
	private ExamType examType;

	
	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	@Cascade(CascadeType.ALL)  // Ensures the user is saved before ExamApplication
	private User user;

//	@OneToOne
//	@JoinColumn(name="user_id", nullable = false)
//	private User user;
//	@OneToOne
//	@JoinColumn(name="payment_id", nullable = false)
//	private Payment payment;
}
