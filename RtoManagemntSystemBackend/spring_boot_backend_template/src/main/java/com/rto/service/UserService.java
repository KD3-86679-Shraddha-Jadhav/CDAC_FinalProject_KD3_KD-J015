package com.rto.service;

import java.util.List;


import com.rto.dto.ApiResponse;
import com.rto.dto.RegDTO;

import com.rto.pojos.User;

public interface UserService {

	ApiResponse addNewUser(RegDTO dto);
	ApiResponse updateUser( User user);
	List<User> getAllUsers();
}
