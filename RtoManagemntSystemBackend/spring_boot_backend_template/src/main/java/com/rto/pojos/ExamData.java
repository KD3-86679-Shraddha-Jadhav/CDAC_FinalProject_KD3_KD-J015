package com.rto.pojos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="examData")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ExamData extends BaseEntity {

	@Column(length=250, unique=true,nullable=false)
	private String questions;
	@Column(length=250,nullable = false)
	private String optA;
	@Column(length=250,nullable = false)
	private String optB;
	@Column(length=250,nullable = false)
	private String optC;
	@Column(length=250,nullable = false)
	private String optD;
	@Enumerated(EnumType.STRING)
	private Answer correctAns;

	//@ManyToMany(mappedBy = "answer_id")
	//private Set<Answer> answer = new HashSet<Answer>();
	@OneToOne
	@JoinColumn(name="userans_id")
	private UserAnswer userans;
	
	public ExamData(String questions, String optA, String optB, String optC, String optD, Answer correctAns) {
		this.questions = questions;
		this.optA = optA;
		this.optB = optB;
		this.optC = optC;
		this.optD = optD;
		this.correctAns = correctAns;
	}

	 public List<String> getOptions() {
	        return List.of(optA, optB, optC, optD);
	    }

	

}
