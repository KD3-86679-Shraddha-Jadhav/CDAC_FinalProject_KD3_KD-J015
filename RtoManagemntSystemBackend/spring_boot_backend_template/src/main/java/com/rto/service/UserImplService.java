package com.rto.service;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import com.rto.custom_exception.ApiException;
import com.rto.dao.UserDao;
import com.rto.dto.ApiResponse;
import com.rto.dto.AuthRequest;
import com.rto.dto.RegDTO;
import com.rto.dto.UpdateDTO;
import com.rto.pojos.Role;
import com.rto.pojos.User;

@Service
@Transactional
public class UserImplService implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
//	@Override
//	public ApiResponse addNewUser(RegDTO dto) {
//		// confirm role
//				if(dto.getRole()==Role.APPLICANT) {
//					//4. map dto -> entity
//					User reg=mapper.map(dto, User.class);			
//					
//					userDao.save(reg);
//					return new ApiResponse("User added ");
//				}
//				
//				throw new ApiException("You must be logged in as User !!!!");
//			}

	@Override
	public ApiResponse addNewUser(RegDTO user) {
		User userEntity=mapper.map(user,User.class);
		userEntity.setRole(Role.ADMIN);
		User persistentUser=userDao.save(userEntity);
		return new ApiResponse("Added new user with ID="
				+ persistentUser.getId());
	}
	
//	@Override
//	public ApiResponse updateUser( User user) {
//		if (userDao.existsById(user.getId())) {
//			userDao.save(user);
//		return new ApiResponse("User Updated !");
//		}
//		return new ApiResponse("Invalid User id");
//	}

	// 2. Admin can view all users
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public RegDTO signIn(AuthRequest dto) {
		// 1. invoke dao's method
		User userEntity = userDao.
				findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow();
		//user entity : persistent -> dto
		return mapper.map(userEntity, RegDTO.class);
	}

	//addApplicant
	@Override
	public ApiResponse addUsers(RegDTO user) {
		User userEntity=mapper.map(user,User.class);
		userEntity.setRole(Role.APPLICANT);
		User persistentUser=userDao.save(userEntity);
		return new ApiResponse("Added new user with ID="
				+ persistentUser.getId());
	}

	//update user
	@Override
	public ApiResponse updateUser(Long userId, UpdateDTO userDto) {
		  User existingUser = userDao.findById(userId)
		            .orElseThrow(() -> new ApiException("User not found with ID: " + userId));

		   
		    mapper.map(userDto, existingUser);

		   
		    User updatedUser = userDao.save(existingUser);

		    return new ApiResponse("User updated successfully with ID: " + updatedUser.getId());
	}

//	@Override
//	public ApiResponse softDeleteUser(Long userId) {
//		User user = userDao.findById(userId)
//		            .orElseThrow(() -> new ApiException("User not found with ID: " + userId));
//
//		    if (user.getStatus() == User.Status.INACTIVE) {
//		        throw new ApiException("User is already inactive!");
//		    }
//
//		    user.setStatus(User.Status.INACTIVE);
//		    userDao.save(user);
//
//		    return new ApiResponse("User with ID: " + userId + " has been marked as inactive.");
//	}

//	//new add user
//	@Override
//	public void addUser(RegDTO dto) {
//		
//		User user=mapper.map(userDao, User.class);
//		user.setRole(Role.ADMIN);
//		user.setPassword/*(encoder.encode*/(user.getPassword());
//		
//		userDao.save(user);
//	}
	
}


