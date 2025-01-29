package com.rto.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.dao.ApplyForLLDao;
import com.rto.dto.ApiResponse;
import com.rto.dto.ApplyForLLReqDTO;
import com.rto.pojos.ApplyForLL;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ApplyForLLServiceImpl implements ApplyForLLService{

	
	@Autowired
	private ApplyForLLDao  applyForLLDao ;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ApiResponse addNewApplyLL(ApplyForLLReqDTO apply) {
		// TODO Auto-generated method stub
		// Map DTO to Entity
		ApplyForLL  savedApplication=modelMapper.map( apply,ApplyForLL.class);
		
		// Save the entity using the DAO
		ApplyForLL persistentAppl=applyForLLDao.save( savedApplication);
		
		 // Return response with ID
		return new ApiResponse("Added new applyLL with id="+  persistentAppl.getId());
	}
	

	
	
}