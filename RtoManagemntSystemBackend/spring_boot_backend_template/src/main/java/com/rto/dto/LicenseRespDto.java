package com.rto.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LicenseRespDto {
    private Long id;
    private String licenseNo;
    private String licenseType;
    private String vehicleType;
    private String examStatus;
    private String approve;
    private String dateOfIssue;
    private String dateOfApply;
}
