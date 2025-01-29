package com.rto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.pojos.AppointmentSlot;

public interface AppointmentDao extends JpaRepository<AppointmentSlot, Long> {

}
