import React, { useState } from 'react';
import { toast } from 'react-toastify';
//import './Appointment.css'; // Assuming the CSS is in Appointment.css
import axios from 'axios';
function DrivingLicenseAppointment() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [dob, setDob] = useState('');
  const [address, setAddress] = useState('');
  const [city, setCity] = useState('');
  const [state, setState] = useState('');
  const [pincode, setPincode] = useState('');
  const [country, setCountry] = useState('');
  //const [isNewLicense, setIsNewLicense] = useState('');
  
  // Function to handle form submission
  const handleSubmit = async() => {
    //if (!firstName || !lastName || !dob || !address || !city || !state || !pincode || !country || isNewLicense === '') {
      if (!firstName || !lastName || !dob || !address || !city || !state || !pincode || !country ) {
      toast.warn('Please fill all the fields.');
      return;
    }

    const formData = {
      firstName,
      lastName,
      dob,
      address,
      city,
      state,
      pincode,
      country,

    };

    try {
      const response = await axios.post('http://localhost:8080/BookAppointment', formData, {
        headers: { 'Content-Type': 'application/json' }
      });

      if (response.status === 201) {
        toast.success('Appointment booked successfully!');
      } else {
        toast.error('Failed to book appointment.');
      }
    } catch (error) {
      console.error('Error submitting appointment:', error);
      toast.error('Something went wrong. Please try again.');
    }
  };

  //   // Simulate a successful form submission
  //   toast.success('Appointment booked successfully!');
  // };

  return (
    <div className="appointment-container">
      <h2>Book Your Driving License Appointment</h2>
      
      <div className="appointment-form">
        <div className="form-group">
          <label>First Name</label>
          <input 
            type="text" 
            value={firstName} 
            onChange={(e) => setFirstName(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>Last Name</label>
          <input 
            type="text" 
            value={lastName} 
            onChange={(e) => setLastName(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>Date of Birth</label>
          <input 
            type="date" 
            value={dob} 
            onChange={(e) => setDob(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>Address</label>
          <input 
            type="text" 
            value={address} 
            onChange={(e) => setAddress(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>City</label>
          <input 
            type="text" 
            value={city} 
            onChange={(e) => setCity(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>State</label>
          <input 
            type="text" 
            value={state} 
            onChange={(e) => setState(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>Pincode</label>
          <input 
            type="text" 
            value={pincode} 
            onChange={(e) => setPincode(e.target.value)} 
            className="form-control" 
          />
        </div>

        <div className="form-group">
          <label>Country</label>
          <input 
            type="text" 
            value={country} 
            onChange={(e) => setCountry(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* <div className="form-group">
          <label>Are you interested in applying for a new license?</label>
          <div className="radio-group">
            <label>
              <input 
                type="radio" 
                name="license" 
                value="new"
                checked={isNewLicense === 'new'}
                onChange={(e) => setIsNewLicense(e.target.value)} 
              />
              New License
            </label>
            <label>
              <input 
                type="radio" 
                name="license" 
                value="update"
                checked={isNewLicense === 'update'}
                onChange={(e) => setIsNewLicense(e.target.value)} 
              />
              Update License
            </label>
          </div>
        </div> */}

        <div className="form-group">
          <button onClick={handleSubmit} className="btn btn-primary">
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}

export default DrivingLicenseAppointment;
