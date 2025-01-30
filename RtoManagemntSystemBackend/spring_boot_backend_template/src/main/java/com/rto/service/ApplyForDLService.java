package com.rto.service;

import java.util.List;

import com.rto.dto.ApiResponse;
import com.rto.dto.ApplyForDLReq;
import com.rto.dto.ApplyForDLResp;
import com.rto.dto.LicenseReqDto;


public interface ApplyForDLService {
	// Add a new driving license application
	ApiResponse addNewApplyDL(ApplyForDLReq apply );
	
	// Fetch details of a driving license application by ID
    ApplyForDLResp getDLApplicationById(Long id);
	
    
    List<ApplyForDLResp>getAll();

    //LicenseReqDto renewLicense(Long id);

	//ApplyForDLResp renewLicense(Long id, ApplyForDLReq applyForDLReq);
}
