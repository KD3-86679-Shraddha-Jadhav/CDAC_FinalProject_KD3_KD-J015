package com.rto.service;

import java.util.List;

import com.rto.dto.ExamDataDTO.ExamDataDto;

public interface ExamService {

	String applyForExam(Long userId);

	List<ExamDataDto> getExamQueSet();
//
//	String getResult(Long userID, String result);

	void saveExamData(ExamDataDto examDataDto);
}
