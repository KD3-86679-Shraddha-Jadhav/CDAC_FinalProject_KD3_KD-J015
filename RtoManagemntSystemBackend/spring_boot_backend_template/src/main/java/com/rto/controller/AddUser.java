package com.rto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rto.dto.ApiResponse;
import com.rto.dto.RegDTO;
import com.rto.service.UserService;

@RestController
@RequestMapping("/addUser")
@CrossOrigin(origins = "http://localhost:3000")

public class AddUser {

	@Autowired
	private UserService userService;
	
//	@PostMapping("/add")
//	public ResponseEntity<?> addNewUser(@RequestBody RegDTO dto)
//	{
//		System.out.println("In add user" +dto);
//		try {
//			return ResponseEntity.status(HttpStatus.CREATED)
//					.body(userService.addNewUser(dto));
//			
//		} catch (RuntimeException e) {
//			System.out.println(e);
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					.body(new ApiResponse(e.getMessage()));
//		}
//	}
	
//	@PostMapping("/signUp")
//	public ResponseEntity<?>signUp(@RequestBody RegDTO user)
//	{
//		Logger logger=LoggerFactory.getLogger(UserController.class);
//	   	logger.info(user.toString());
//		userService.addUser(user);
//		ApiResponse resp=new ApiResponse();
//		resp.setMessage("user added successfully");
//		return ResponseEntity.status(200).body(resp);		
//	}
	
	 //for add admin
    @PostMapping("/add")
	public ResponseEntity<?> addUser
	(@RequestBody RegDTO user) {
		System.out.println("in add user " + user);// transient category
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.addNewUser(user));
	}
    
  //for add user
    @PostMapping("/add/user")
   	public ResponseEntity<?> addUsers
   	(@RequestBody RegDTO user) {
   		System.out.println("in add user " + user);// transient category
   		return ResponseEntity.status(HttpStatus.CREATED)
   				.body(userService.addUsers(user));
   	}

}
