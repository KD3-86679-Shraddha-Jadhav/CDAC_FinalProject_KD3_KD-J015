package com.rto.pojos;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="licenseDetails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class License extends BaseEntity{
@Column(length = 100)
private String LicenseHolder;
@Column(length = 20, unique = true)
private String licenseNo;
@Column(length=30)
private String licenseType;
@Column(length=30)
private String vehicleType;
@Column(length=30)
private String examStatus;
@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private Timestamp dateOfIssue=Timestamp.valueOf(LocalDateTime.now());
@Column()
private Timestamp dateOfApply;
@Column(columnDefinition = "varchar(20) default 'NO'")
private String approve;

@ManyToOne
@JoinColumn(name="user_id")
private User user;

}
