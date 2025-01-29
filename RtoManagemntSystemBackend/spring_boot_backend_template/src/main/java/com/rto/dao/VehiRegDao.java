package com.rto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.pojos.VehicleRegisteration;

public interface VehiRegDao extends JpaRepository<VehicleRegisteration, Long> {

}
