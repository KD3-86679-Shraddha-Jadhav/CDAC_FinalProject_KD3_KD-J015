package com.rto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.dto.LicenseReqDto;
import com.rto.dto.LicenseRespDto;
import com.rto.service.LicenseRenewService;

@RestController
@RequestMapping("/license")
@CrossOrigin()
@Validated
public class LicenseController {

	 @Autowired
	    private LicenseRenewService licenseService;
	 
	 // POST method to create a new license (Admin only)
	    @PostMapping("/create")
	    public ResponseEntity<?> createLicense(@RequestBody LicenseReqDto licenseReqDto, @RequestHeader("Role") String role) {
	        // Check if the user is an admin
	        if (!"admin".equalsIgnoreCase(role)) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN)
	                    .body("Only admins can create licenses.");
	        }

	        try {
	            // Create a new license using the service layer
	            LicenseRespDto createdLicense = licenseService.createLicense(licenseReqDto);
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdLicense);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }

	 // PUT method for license renewal (Admin only)
	    @PutMapping("/renew/{id}")
	    public ResponseEntity<?> renewLicense(@PathVariable Long id, @RequestHeader("Role") String role) {
	        //  Admin authorization check
	        if (!"admin".equalsIgnoreCase(role)) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN)
	                    .body("Only admins can renew licenses.");
	        }

	        
	        try {
	            LicenseReqDto updatedLicense = licenseService.renewLicense(id);
	            return ResponseEntity.ok(updatedLicense);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
}
