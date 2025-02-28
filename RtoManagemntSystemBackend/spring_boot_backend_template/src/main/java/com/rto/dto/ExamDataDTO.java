package com.rto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.rto.pojos.Answer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ExamDataDTO {

	@Getter
	@Setter
	@ToString
	public static class ExamDataDto {
		@JsonProperty(access=Access.READ_ONLY)
		private Long id;
		
		private String questions;
		private String optA;
		private String optB;
		private String optC;
		private String optD;
		
		
		@JsonProperty(access =Access.WRITE_ONLY)
		private Answer correctAns;
	}
}
