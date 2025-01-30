package com.rto.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LicenseReqDto {
	 private Long id;
	    private String licenseNo;
	    private String licenseType;
	    private String vehicleType;
	    private String examStatus;
	    private String approve;
	    private String dateOfIssue;
	    private String dateOfApply;
}
