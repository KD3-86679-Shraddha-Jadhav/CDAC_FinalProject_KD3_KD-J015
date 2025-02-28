package com.rto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.dto.ApiResponse;
import com.rto.dto.ApplyForDLReq;
import com.rto.dto.ApplyForDLResp;
import com.rto.dto.LicenseReqDto;
import com.rto.service.ApplyForDLService;
import com.rto.service.LicenseRenewService;




@RestController
@RequestMapping("/DrivingLic")
@CrossOrigin(origins = "http://localhost:3000")

public class ApplyForDLController {
	
	
@Autowired
private ApplyForDLService applyForDLService ;
	public ApplyForDLController() {
		System.out.println("in ctor " + getClass());
		
	}
	
	
	
	@PostMapping
	public ResponseEntity<?>addNewApplyDL
	(@RequestBody ApplyForDLReq apply)
	{
		System.out.println("in add driving license"+apply);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(applyForDLService.addNewApplyDL(apply));
	}
		
	
	@GetMapping("/{id}")
	//("id") dl id consider
	public ResponseEntity<?>getDLDetails(@PathVariable ("id")Long Id){
	System.out.println("in get dtls " + Id);
	try {
		
		//ApplyForDLReq Application=applyForDLService
		ApplyForDLResp Application=applyForDLService
				.getDLApplicationById(Id);
		return ResponseEntity.ok(Application);
		
	}
	catch(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
		.body(new ApiResponse(e.getMessage()));
	}
	
}
	
	
	@GetMapping
	public ResponseEntity<?> getAllDL() {
		System.out.println("get all");
		List<ApplyForDLResp> Application = 
				
				applyForDLService.getAll();
		if (Application.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(Application);
	}
	
//	 // PUT method to renew DL (New functionality)
//    @PutMapping("/renew/{id}")
//    public ResponseEntity<?> renewLicense(@PathVariable("id") Long id, @RequestBody ApplyForDLReq applyForDLReq, @RequestHeader("Role") String role) {
//        // Check if the user is admin
//        if (!role.equalsIgnoreCase("admin")) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN)
//                    .body(new ApiResponse("Only admins can renew licenses."));
//        }
//
//        // Update the DL application details
//        try {
//            ApplyForDLResp updatedApplication = applyForDLService.renewLicense(id, applyForDLReq);
//            return ResponseEntity.ok(updatedApplication);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ApiResponse(e.getMessage()));
//        }
//    }
	
//	@Autowired
//    private LicenseRenewService licenseService;
//
// // PUT method for license renewal (Admin only)
//    @PutMapping("/renew/{id}")
//    public ResponseEntity<?> renewLicense(@PathVariable Long id, @RequestHeader("Role") String role) {
//        // ✅ Admin authorization check
//        if (!"admin".equalsIgnoreCase(role)) {
//            return ResponseEntity.status(HttpStatus.FORBIDDEN)
//                    .body("Only admins can renew licenses.");
//        }
//
//        
//        try {
//            LicenseReqDto updatedLicense = licenseService.renewLicense(id);
//            return ResponseEntity.ok(updatedLicense);
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
//    }
}

