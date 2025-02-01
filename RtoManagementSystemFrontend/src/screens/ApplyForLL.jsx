




import React, { useState } from 'react';
import { toast } from 'react-toastify'; // For showing toast messages
import { useNavigate } from 'react-router-dom'; // To navigate after successful registration
import axios from 'axios';
const ApplyForLL = () => {
  const [fullName, setFullName] = useState('');
  const [dob, setDob] = useState('');
 
  const [bloodgroup, setBloodGroup] = useState('');
  const [address, setAddress] = useState('');
  const [phonenumber, setPhone] = useState('');
  const [email, setEmail] = useState('');
  const [vehicleDetails, setVehicleDetails] = useState('');

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!fullName || !dob   || !bloodgroup || !address || !phonenumber || !vehicleDetails || !email) {
      toast.error('All fields are required!');
      return;
    }

    const formData = {
      fullName,
      dob,
      bloodgroup,
      address,
      phonenumber,
      email,
      vehicleDetails,
    };
    try {
      const result = await axios.post('http://localhost:8080/learLic', formData, {
        headers: { 'Content-Type': 'application/json' }
      });
      if (result.status === 201) {

    toast.success('License Registration Successful!');
    navigate('/dashboard');
      }else {
        toast.error('Failed to apply for LL.');
      }
    } catch (error) {
      console.error('Error submitting application:', error);
      toast.error('Something went wrong. Please try again.');
    }
  };

  return (
    <div>
      <h2 className="text-center fs-1">Apply for LL</h2>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <form onSubmit={handleSubmit}>
            <div className="mb-3 fs-4">
              <label htmlFor="fullName" className="form-label">Full Name</label>
              <input
                onChange={(e) => setFullName(e.target.value)}
                type="text"
                id="fullName"
                className="form-control fs-4"
                value={fullName}
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            <div className="mb-3 fs-4">
              <label htmlFor="dob" className="form-label">Date of Birth</label>
              <input
                type="date"
                className="form-control fs-4"
                id="dob"
                value={dob}
                onChange={(e) => setDob(e.target.value)}
                required
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            
            <div className="mb-3 fs-4">
              <label htmlFor="bloodGroup" className="form-label">Blood Group</label>
              <input
                onChange={(e) => setBloodGroup(e.target.value)}
                type="text"
                className="form-control fs-4"
                id="bloodGroup"
                value={bloodgroup}
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            <div className="mb-3 fs-4">
              <label htmlFor="address" className="form-label">Address</label>
              <input
                onChange={(e) => setAddress(e.target.value)}
                type="text"
                className="form-control fs-4"
                id="address"
                value={address}
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            <div className="mb-3 fs-4">
              <label htmlFor="phone" className="form-label">Phone Number</label>
              <input
                onChange={(e) => setPhone(e.target.value)}
                type="tel"
                className="form-control fs-4"
                id="phone"
                value={phonenumber}
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            <div className="mb-3 fs-4">
              <label htmlFor="email" className="form-label">Email</label>
              <input
                onChange={(e) => setEmail(e.target.value)}
                type="email"
                className="form-control fs-4"
                id="email"
                value={email}
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            <div className="mb-3 fs-4">
              <label htmlFor="vehicleDetails" className="form-label">Vehicle Details</label>
              <input
                onChange={(e) => setVehicleDetails(e.target.value)}
                type="text"
                className="form-control fs-4"
                id="vehicleDetails"
                value={vehicleDetails}
                style={{ width: '400px' }} // Set text box size
              />
            </div>

            <button type="submit" className="btn btn-primary fs-4">
              Submit
            </button>
          </form>
        </div>
        <div className="col"></div>
      </div>
    </div>
  );
};




export default ApplyForLL;

