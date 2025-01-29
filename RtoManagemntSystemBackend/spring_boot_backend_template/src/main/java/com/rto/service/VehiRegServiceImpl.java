package com.rto.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rto.dao.VehiRegDao;
import com.rto.dto.ApiResponse;
import com.rto.dto.VehiRegDTO;
import com.rto.pojos.VehicleRegisteration;

@Service
@Transactional
public class VehiRegServiceImpl implements VehiRegService {

	@Autowired
	private VehiRegDao vehiRegDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse addNewVehicle(VehiRegDTO vehi) {
		VehicleRegisteration vehiReg=modelMapper.map(vehi, VehicleRegisteration.class);
		VehicleRegisteration persistentVechi = vehiRegDao.save(vehiReg);
		return new ApiResponse("Your Vehicle is Registered Successfully");
	}

}
