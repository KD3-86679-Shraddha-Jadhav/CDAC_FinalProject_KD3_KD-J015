package com.rto.pojos;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;


import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




	
	

@Entity
@Table(name = "DrivingLicenseForm") // Specify the table name in the database
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ApplyForDL extends BaseEntity {

    @Column(name = "LearningLicenseNumber", length = 20, unique = true) // Field for learning license number
    private String learningLicenseNumber;

    @Column(name = "AadharNumber", length = 12, unique = true) // Field for Aadhar number (12-digit)
    private String aadharNumber;

//    @OneToOne
//    @JoinColumn(name = "learning_license_id", nullable = false, unique = true) // FK to ApplyForLL
//    private ApplyForLL learningLicense;

    
    // Constructors, Getters, Setters, etc.
    public ApplyForDL(String learningLicenseNumber, String aadharNumber) {
      
        this.learningLicenseNumber = learningLicenseNumber;
        this.aadharNumber = aadharNumber;
        
    }
}
