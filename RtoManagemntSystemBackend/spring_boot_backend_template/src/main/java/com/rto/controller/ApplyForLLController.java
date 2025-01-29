package com.rto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.dto.ApplyForLLReqDTO;
import com.rto.service.ApplyForLLService;

@RestController
@RequestMapping("/learLic")
@CrossOrigin(origins = "http://localhost:3000")

public class ApplyForLLController {
	@Autowired
	
	private ApplyForLLService  applyForLLService ;

	public ApplyForLLController() {
		System.out.println("in ctor " + getClass());
		
	}
	
	
	@PostMapping
	public ResponseEntity<?>addNewApplyLL
	(@RequestBody ApplyForLLReqDTO applyll ){
		System.out.println("in add newll" + applyll );
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(applyForLLService .addNewApplyLL(applyll));
	}
}
