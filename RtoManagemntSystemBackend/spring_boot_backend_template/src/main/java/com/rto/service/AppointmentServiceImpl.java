package com.rto.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rto.dao.AppointmentDao;
import com.rto.dto.ApiResponse;
import com.rto.dto.AppointmentDTO;
import com.rto.dto.VehiRegDTO;
import com.rto.pojos.AppointmentSlot;
import com.rto.pojos.VehicleRegisteration;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ApiResponse addAppointment(AppointmentDTO dto) {
		AppointmentSlot appo=modelMapper.map(dto, AppointmentSlot.class);
		AppointmentSlot persistAppoi = appointmentDao.save(appo);
		return new ApiResponse("Your Appointment is Booked");
	}
}
