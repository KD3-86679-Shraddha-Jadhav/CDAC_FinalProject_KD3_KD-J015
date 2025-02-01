package com.rto.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rto.pojos.License;

public interface LicenseDao extends JpaRepository<License, Long> {
}
