package com.rto.service;

import com.rto.dto.ApplyForDLReq;
import com.rto.dto.ApplyForDLResp;
import com.rto.dto.LicenseReqDto;
import com.rto.dto.LicenseRespDto;

public interface LicenseRenewService {

	LicenseReqDto renewLicense(Long id);
	
	 LicenseRespDto createLicense(LicenseReqDto licenseReqDto);
}
