package com.rto.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.rto.dto.ApiResponse;
import com.rto.dto.AuthRequest;
import com.rto.dto.RegDTO;
import com.rto.dto.UpdateDTO;
import com.rto.pojos.User;


import com.rto.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")

public class UserController {
	//depcy
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private SignInService signInUser;
	//depcy
	
	
	/*
	 * Desc - user sign in
	 * URL - http://host:port/users/signin
	 * Method - POST (for security)
	 * payload -  DTO (email , pwd)
	 * success resp - user details - dto
	 * err resp  - api resp - err mesg
	 * 
	 */
	//sign in for both user and admin
	@PostMapping("/signIn")
	public ResponseEntity<?> userSignIn(@RequestBody AuthRequest dto)
	{
		System.out.println("in user sign in "+dto);
		try {
			return ResponseEntity.ok(userService.signIn(dto));
		} catch (RuntimeException e) {
			//SC 401 , err mesg
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
//	//update user or admin
//	@PutMapping("/{userId}")
//	public ResponseEntity<?> updateUserDetails
//	(@PathVariable Long userId, @RequestBody User user) {
//		System.out.println("in update user " + userId + " " + user);
//
//		return ResponseEntity.ok(
//				userService.updateUser(user));
//
//	}
	
	//update user 
    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateUserDetails(@PathVariable Long userId,@RequestBody UpdateDTO user)
    {
    	System.out.println("in update user " + userId + " " + user);
    
    return ResponseEntity.ok(userService.updateUser(userId, user));
    }
	
	//get all users by admin
	@GetMapping
	public ResponseEntity<?> getAllUsers()
	{
		System.out.println("in get all users");
		List<User> user = userService.getAllUsers();
		if(user.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(user);
	}
}
