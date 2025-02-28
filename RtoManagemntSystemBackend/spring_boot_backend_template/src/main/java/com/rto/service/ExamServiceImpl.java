package com.rto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rto.dao.ApplyForDLDao;
import com.rto.dao.ApplyForLLDao;
import com.rto.dao.ExamDataDao;
import com.rto.dto.ExamDataDTO.ExamDataDto;
import com.rto.pojos.Answer;
import com.rto.pojos.ApplyForLL;
import com.rto.pojos.ExamData;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ApplyForLLDao lldao;
	
	@Autowired
	private ApplyForDLDao dldao;
	
	@Autowired
	private ExamDataDao examdao;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String applyForExam(Long userId) {
	    ApplyForLL ll = lldao.findById(userId)
	            .orElseThrow(() -> new NoSuchElementException("No record found for user ID: " + userId));
	    return "You can start the exam.";
	}

	
//	@Override
//	public String applyForExam(Long userId) {
//		ApplyForLL ll = lldao.findById(userId)
//				.orElseThrow(() -> new NoSuchElementException());
//		//System.out.println(ll.getLearningLicenseNo());
//		return "You can start exam.";
//	}

//	@Override
//	public List<ExamDataDto> getExamQueSet() {
//		
//		return null;
//	}
	
	@Override
	public List<ExamDataDto> getExamQueSet() {
	    List<ExamData> examList = new ArrayList<>(examdao.findAll()); // Convert Set to List
	    List<ExamDataDto> examDataDTOList = new ArrayList<>();
	    
	    for (ExamData examData : examList) {
	        examDataDTOList.add(mapper.map(examData, ExamDataDto.class)); // Mapping each entity to DTO
	    }
	    
	    return examDataDTOList;
	}
//
//	@Override
//	public String getResult(Long userID, String result) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	 @Override
	    public void saveExamData(ExamDataDto examDataDto) {
	        // Convert DTO to Entity
	        ExamData examData = new ExamData(
	            examDataDto.getQuestions(),
	            examDataDto.getOptA(),
	            examDataDto.getOptB(),
	            examDataDto.getOptC(),
	            examDataDto.getOptD(),
	            examDataDto.getCorrectAns()  // Correct answer is already in the Answer enum
	        );

	        // Save ExamData entity to the database
	        examdao.save(examData);
	    }
	
}


