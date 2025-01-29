package com.rto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.dto.AppointmentDTO;
import com.rto.service.AppointmentService;

@RestController
@RequestMapping("/BookAppointment")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {
	
    @Autowired
    private AppointmentService appointmentService;
    
    @PostMapping
    public ResponseEntity<?> addAppointment(@RequestBody AppointmentDTO appointment)
    {
    	System.out.println("in add appointment" + appointment);
    	return ResponseEntity.status(HttpStatus.CREATED)
    			.body(appointmentService.addAppointment(appointment));
    	
    }
}
