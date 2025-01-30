package com.rto.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rto.dao.LicenseDao;
import com.rto.dto.ApplyForDLReq;
import com.rto.dto.ApplyForDLResp;
import com.rto.dto.LicenseReqDto;
import com.rto.dto.LicenseRespDto;
import com.rto.pojos.ApplyForDL;
import com.rto.pojos.License;

@Service
@Transactional
public class LicenseRenewServiceImpl implements LicenseRenewService {

	 @Autowired
	    private LicenseDao licenseDao;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public LicenseReqDto renewLicense(Long id) {
	        // Fetch license details
	        License existingLicense = licenseDao.findById(id)
	                .orElseThrow(() -> new RuntimeException("License not found with ID: " + id));

	        // Update approval status to "YES" for renewal
	        existingLicense.setApprove("YES");

	        // Save updated license
	        licenseDao.save(existingLicense);

	        // Return the updated license details as response
	        return modelMapper.map(existingLicense, LicenseReqDto.class);
	    }

	    @Override
	    public LicenseRespDto createLicense(LicenseReqDto licenseReqDto) {
	        // Map DTO to Entity
	        License newLicense = modelMapper.map(licenseReqDto, License.class);
//
//	        // Set additional necessary fields (e.g., auto-generate licenseNo if needed)
//	        newLicense.setLicenseNo(generateLicenseNumber());  // Example: Create a unique license number.

	        // Save the new license to the database
	        License savedLicense = licenseDao.save(newLicense);

	        // Return response DTO
	        return modelMapper.map(savedLicense, LicenseRespDto.class);
	    }

}
