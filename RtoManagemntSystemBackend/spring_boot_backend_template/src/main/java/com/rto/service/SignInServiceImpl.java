package com.rto.service;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rto.dao.UserDao;
import com.rto.dto.AuthRequest;
import com.rto.dto.RegDTO;

import com.rto.pojos.User;

@Service
@Transactional
public class SignInServiceImpl implements SignInService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public RegDTO signIn(AuthRequest dto) {
		// 1. invoke dao's method
				User userEntity = userDao.
						findByEmailAndPassword(dto.getEmail(), dto.getPassword())
						.orElseThrow();
				//user entity : persistent -> dto
				return modelMapper.map(userEntity, RegDTO.class);
	}

}
