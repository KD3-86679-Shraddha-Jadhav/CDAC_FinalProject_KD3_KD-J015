import React, { useState } from "react";
 import "./ApplyForDL.css";
 

function ApplyForDL() {
  // State to hold form values
  const [learningLicense, setLearningLicense] = useState("");
  const [aadharNumber, setAadharNumber] = useState("");
  const [message, setMessage] = useState(""); // To hold success/error message

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault(); // Prevent page refresh on submit

    // Validate the Learning License and Aadhar Number
    if (learningLicense.length === 15 && aadharNumber.length === 12) {
      // Display success message
      setMessage("Form Submitted Successfully!");
      
      // Optionally, reset the form after success
      setLearningLicense("");
      setAadharNumber("");
    } else {
      // Show error message if validation fails
      setMessage("Please enter valid Learning License Number and Aadhar Number.");
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
            value={learningLicense}
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
