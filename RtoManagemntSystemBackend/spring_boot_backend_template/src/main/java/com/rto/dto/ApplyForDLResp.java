package com.rto.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ApplyForDLResp extends BaseDTO {
	private String learningLicenseNumber;
    private String aadharNumber;
}
