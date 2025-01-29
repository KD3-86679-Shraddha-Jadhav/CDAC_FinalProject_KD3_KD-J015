package com.rto.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.rto.pojos.ApplyForLL;

public interface ApplyForLLDao extends JpaRepository<ApplyForLL, Long> {
	//List<ApplyForLL> findByRole(String role);
}
