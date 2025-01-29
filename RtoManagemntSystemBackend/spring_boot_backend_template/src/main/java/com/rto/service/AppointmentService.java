package com.rto.service;

import com.rto.dto.ApiResponse;
import com.rto.dto.AppointmentDTO;

public interface AppointmentService {

	ApiResponse addAppointment(AppointmentDTO dto);
}
