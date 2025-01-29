package com.rto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.dao.ApplyForDLDao;
import com.rto.dto.ApiResponse;
import com.rto.dto.ApplyForDLReq;
import com.rto.dto.ApplyForDLResp;
import com.rto.pojos.ApplyForDL;


import jakarta.transaction.Transactional;


@Service
@Transactional
public class ApplyForDLServiceImpl implements ApplyForDLService{

	
	
		

		@Autowired
		private ApplyForDLDao  applyForDLDao ;
		
		@Autowired
		private ModelMapper modelMapper;

		@Override
		public ApiResponse addNewApplyDL(ApplyForDLReq apply) {
			// TODO Auto-generated method stub
			// Map DTO to Entity
			ApplyForDL  savedApplication=modelMapper.map( apply,ApplyForDL.class);
			
			// Save the entity using the DAO
			ApplyForDL persistentAppl=applyForDLDao.save( savedApplication);
			
			 // Return response with ID
			return new ApiResponse("Added new applydL with id="+  persistentAppl.getId());
		}
		
	

	@Override
	public ApplyForDLResp getDLApplicationById(Long ID) {
		ApplyForDL application=applyForDLDao.findById(ID)
			.orElseThrow(() ->new RuntimeException("Driving License application not found!"));

		// Map the entity to the response DTO
        return modelMapper.map(application, ApplyForDLResp.class);
	}



	@Override
	public List<ApplyForDLResp> getAll() {
	return applyForDLDao.findAll()
			.stream()
			.map(ApplyForDL->modelMapper.map(ApplyForDL,ApplyForDLResp.class))
					.collect(Collectors.toList());
	
	}

}
