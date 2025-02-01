import React, { useState } from "react";
 import "./ApplyForDL.css";
 import axios from "axios";

function ApplyForDL() {
  // State to hold form values
  const [learningLicenseNumber, setLearningLicense] = useState("");
  const [aadharNumber, setAadharNumber] = useState("");
  const [message, setMessage] = useState(""); // To hold success/error message

  // Handle form submission
  const handleSubmit =async (e) => {
    e.preventDefault(); // Prevent page refresh on submit

    // Validate the Learning License and Aadhar Number
    if (learningLicenseNumber.length !== 15 || aadharNumber.length !== 12){
      // Display success message
      setMessage("Please enter valid Learning License Number and Aadhar Number.");
      
    }
      // Prepare form data
    const formData = {
      learningLicenseNumber,
      aadharNumber,
    };

    try {
      // Send POST request to backend
      const result = await axios.post("http://localhost:8080/DrivingLic", formData, {
        headers: { "Content-Type": "application/json" },
      });

      // Handle success response
      if (result.status === 201) {
        setMessage("Driving License Application Submitted Successfully!");
        setLearningLicense("");
        setAadharNumber("");
      } else {
        setMessage("Failed to apply for Driving License. Please try again.");
      }
    } catch (error) {
      console.error("Error submitting form:", error);
      setMessage("An error occurred. Please try again later.");
    }
      
  };

  return (
    <div style={{ margin: "50px", padding: "20px", border: "1px solid #ccc", width: "300px" }}>
      <h2>Driving License Form</h2>
      
      <form onSubmit={handleSubmit}>
        {/* Learning License Number Field */}
        <div>
          <label htmlFor="learning_license_no">Learning License Number:</label>
          <input
            type="text"
            id="learning_license_no"
            value={learningLicenseNumber}
            onChange={(e) => setLearningLicense(e.target.value)}
            required
            pattern="\d{15}"
            title="15 digits required"
            maxLength="15"
          />
        </div>
        <br />
        
        {/* Aadhar Number Field */}
        <div>
          <label htmlFor="aadhar_no">Aadhar Number:</label>
          <input
            type="text"
            id="aadhar_no"
            value={aadharNumber}
            onChange={(e) => setAadharNumber(e.target.value)}
            required
            pattern="\d{12}"
            title="12 digits required"
            maxLength="12"
          />
        </div>
        <br />

        {/* Submit Button */}
        <button type="submit">Submit</button>
      </form>

      {/* Message Display */}
      {message && <div style={{ marginTop: "20px", color: message.includes("Successfully") ? "green" : "red" }}>{message}</div>}
    </div>
  );
}

export default ApplyForDL;
