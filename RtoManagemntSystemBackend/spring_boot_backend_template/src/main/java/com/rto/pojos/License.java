//package com.rto.pojos;
//
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name="licenseDetails")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//public class License extends BaseEntity{
////@Column(length = 100)
////private String LicenseHolder;
//@Column(length = 20, unique = true)
//private String licenseNo;
//@Column(length=30)
//private String licenseType;
//@Column(length=30)
//private String vehicleType;
//@Column(length=30)
//private String examStatus;
//@Column
//private LocalDate dateOfIssue;
//@Column
//private LocalDate dateOfApply;
//@Column(columnDefinition = "varchar(20) default 'NO'")
//private String approve;
//
//@ManyToOne
//@JoinColumn(name="user_id")
//private User user;
//
//}

package com.rto.pojos;

import java.time.LocalDate;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Entity
@Table(name = "licenseDetails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class License extends BaseEntity {

    @Column(length = 100)
    private String licenseHolder;

    @Column(length = 20, unique = true)
    private String licenseNo;

    @Column(length = 30)
    private String licenseType;

    @Column(length = 30)
    private String vehicleType;

    @Column(length = 30)
    private String examStatus;

    @Column()
    @JsonFormat()
    private LocalDate dateOfIssue;

    @Column()
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfApply;

    @Column(columnDefinition = "varchar(20) default 'NO'")
    private String approve;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    public void prePersist() {
        if (dateOfApply == null) {
            dateOfApply = LocalDate.now();  //set default value or adjust or format before saved in database provide not null value
        }
    }
}
