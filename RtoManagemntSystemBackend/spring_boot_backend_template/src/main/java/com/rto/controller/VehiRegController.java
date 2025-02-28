package com.rto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.dto.VehiRegDTO;
import com.rto.service.VehiRegService;

@RestController
@RequestMapping("/VehicleReg")
@CrossOrigin(origins = "http://localhost:3000")
public class VehiRegController {

	@Autowired
	private VehiRegService vehiRegService;

	public VehiRegController() {
		System.out.println("in ctor " + getClass());

	}
	
	@PostMapping
	public ResponseEntity<?> addNewVehicle(@RequestBody VehiRegDTO vehi )
	{
		System.out.println("in add Vehicle " + vehi);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(vehiRegService.addNewVehicle(vehi));
		
	}
	
	
}
