package com.rto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.pojos.ExamData;

public interface ExamDataDao extends JpaRepository<ExamData, Long> {

	
}
