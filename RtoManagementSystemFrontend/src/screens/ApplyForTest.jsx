import React, { useState } from 'react';
import { toast } from 'react-toastify';

function TestApplication() {
  const [learningLicenseNo, setLearningLicenseNo] = useState('');
  const [aadharNo, setAadharNo] = useState('');
  const [testDate, setTestDate] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  // Function to handle form submission
  const handleSubmit = () => {
    if (!learningLicenseNo || !aadharNo || !testDate) {
      setErrorMessage('Please fill in all fields');
      toast.warn('Please fill in all fields');
      return;
    }

    // Simulating an API request or form submission
    // You can replace this with actual API logic
    toast.success('Test application submitted successfully');
    console.log({
      learningLicenseNo,
      aadharNo,
      testDate,
    });
    
    // Clear form after submission
    setLearningLicenseNo('');
    setAadharNo('');
    setTestDate('');
  };

  return (
    <div className="test-application-container">
      <h2>Apply for Driving Test</h2>
      
      <div className="form-container">
        {/* Learning License Number */}
        <div className="form-group">
          <label htmlFor="learningLicenseNo">Learning License Number</label>
          <input
            type="text"
            id="learningLicenseNo"
            value={learningLicenseNo}
            onChange={(e) => setLearningLicenseNo(e.target.value)}
            className="form-control"
          />
        </div>

        {/* Aadhar Number */}
        <div className="form-group">
          <label htmlFor="aadharNo">Aadhar Number</label>
          <input
            type="text"
            id="aadharNo"
            value={aadharNo}
            onChange={(e) => setAadharNo(e.target.value)}
            className="form-control"
          />
        </div>

        {/* Test Date */}
        <div className="form-group">
          <label htmlFor="testDate">Test Date</label>
          <input
            type="date"
            id="testDate"
            value={testDate}
            onChange={(e) => setTestDate(e.target.value)}
            className="form-control"
          />
        </div>

        {/* Error Message */}
        {errorMessage && <div className="error-message">{errorMessage}</div>}

        {/* Submit Button */}
        <div className="form-group">
          <button onClick={handleSubmit} className="btn btn-primary">
            Apply for Test
          </button>
        </div>
      </div>
    </div>
  );
}

export default TestApplication;
