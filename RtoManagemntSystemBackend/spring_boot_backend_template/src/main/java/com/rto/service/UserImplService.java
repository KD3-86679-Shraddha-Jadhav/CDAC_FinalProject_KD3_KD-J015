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
import com.rto.dto.RegDTO;
import com.rto.pojos.Registeration;
import com.rto.pojos.Role;

@Service
@Transactional
public class UserImplService implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ApiResponse addNewUser(RegDTO dto) {
		// confirm role
				if(dto.getRole()==Role.USER) {
					//4. map dto -> entity
					Registeration reg=mapper.map(dto, Registeration.class);			
					
					userDao.save(reg);
					return new ApiResponse("User added ");
				}
				
				throw new ApiException("You must be logged in as User !!!!");
			}

	@Override
	public ApiResponse updateUser( Registeration user) {
		if (userDao.existsById(user.getId())) {
			userDao.save(user);
		return new ApiResponse("User Updated !");
		}
		return new ApiResponse("Invalid User id");
	}

	// 2. Admin can view all users
	@Override
	public List<Registeration> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	
}


