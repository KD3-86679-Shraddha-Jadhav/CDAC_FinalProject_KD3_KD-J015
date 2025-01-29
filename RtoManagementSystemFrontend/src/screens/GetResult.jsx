import React, { useState } from 'react';
import { toast } from 'react-toastify';

function TestResult() {
  const [learningLicenseNo, setLearningLicenseNo] = useState('');
  const [aadharNo, setAadharNo] = useState('');
  const [testResult, setTestResult] = useState(null);
  const [errorMessage, setErrorMessage] = useState('');

  // Simulating an API call to fetch test results
  const handleCheckResult = () => {
    if (!learningLicenseNo && !aadharNo) {
      setErrorMessage('Please provide either Learning License Number or Aadhar Number.');
      toast.warn('Please provide either Learning License Number or Aadhar Number.');
      return;
    }

    
    if (learningLicenseNo === '12345' || aadharNo === '123456789012') {
      // passing the test
      setTestResult({ status: 'Passed', message: 'Congratulations! You have passed the test.' });
      toast.success('Test Passed!');
    } else {
      //  failing the test
      setTestResult({ status: 'Failed', message: 'Sorry, you did not pass the test. Please try again.' });
      toast.error('Test Failed!');
    }
  };

  return (
    <div className="test-result-container">
      <h2>Check Your Test Result</h2>
      
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

        {/* Error Message */}
        {errorMessage && <div className="error-message">{errorMessage}</div>}

        {/* Check Result Button */}
        <div className="form-group">
          <button onClick={handleCheckResult} className="btn btn-primary">
            Check Result
          </button>
        </div>
      </div>

      {/* Display Test Result */}
      {testResult && (
        <div className="result-container">
          <h3>Test Result</h3>
          <div className={`result-message ${testResult.status === 'Passed' ? 'success' : 'failed'}`}>
            <strong>Status: {testResult.status}</strong>
            <p>{testResult.message}</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default TestResult;
