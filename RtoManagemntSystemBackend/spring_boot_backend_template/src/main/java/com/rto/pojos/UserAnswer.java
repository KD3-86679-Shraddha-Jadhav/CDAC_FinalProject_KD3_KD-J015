package com.rto.pojos;

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
@Table(name="user_answer")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswer extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private Answer ans;

	@OneToOne
	@JoinColumn(name="examdata_id",nullable = false)
	private ExamData examdata;
}
