import React, { useState } from 'react';
import { toast } from 'react-toastify';
//import { Link,useNavigate } from 'react-router-dom'
//import './VehicleRegistration.css'; // Assuming the CSS is in VehicleRegistration.css

function VehicleRegistration() {
  // States to store form data
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [vehicleType, setVehicleType] = useState('');
  const [vehicleModel, setVehicleModel] = useState('');
  const [licensePlate, setLicensePlate] = useState('');
  const [address, setAddress] = useState('');
  const [city, setCity] = useState('');

  // Function to handle form submission
  const handleSubmit = () => {
    if (!firstName || !lastName || !email || !phone || !vehicleType || !vehicleModel || !licensePlate || !address || !city) {
      toast.warn('Please fill all fields!');
      return;
    }
    
    toast.success('Vehicle registration successful!');
    // Form submission logic can be added here (e.g., send data to a backend API)
  };

  return (
    <div className="vehicle-registration-container">
      <h2 className="registration-header"> User Vehicle Registration</h2>
      
      <div className="registration-form">
        {/* First Name */}
        <div className="form-group">
          <label>First Name</label>
          <input 
            type="text" 
            value={firstName} 
            onChange={(e) => setFirstName(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* Last Name */}
        <div className="form-group">
          <label>Last Name</label>
          <input 
            type="text" 
            
            value={lastName} 
            onChange={(e) => setLastName(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* Email */}
        <div className="form-group">
          <label>Email</label>
          <input 
            type="email" 
            value={email} 
            onChange={(e) => setEmail(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* Phone Number */}
        <div className="form-group">
          <label>Phone Number</label>
          <input 
            type="tel" 
            value={phone} 
            onChange={(e) => setPhone(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* Vehicle Type */}
        <div className="form-group">
          <label>Vehicle Type</label>
          <select 
            value={vehicleType} 
            onChange={(e) => setVehicleType(e.target.value)} 
            className="form-control"
          >
            <option value="">Select Vehicle Type</option>
            <option value="Car">Car</option>
            <option value="Bike">Bike</option>
            <option value="Truck">Truck</option>
            <option value="Other">Other</option>
          </select>
        </div>

        {/* Vehicle Model */}
        <div className="form-group">
          <label>Vehicle Model</label>
          <input 
            type="text" 
            value={vehicleModel} 
            onChange={(e) => setVehicleModel(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* License Plate Number */}
        <div className="form-group">
          <label>License Plate Number</label>
          <input 
            type="text" 
            value={licensePlate} 
            onChange={(e) => setLicensePlate(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* Address */}
        <div className="form-group">
          <label>Address</label>
          <input 
            type="text" 
            value={address} 
            onChange={(e) => setAddress(e.target.value)} 
            className="form-control" 
          />
        </div>

        {/* City */}
        <div className="form-group">
          <label>City</label>
          <input 
            type="text" 
            value={city} 
            onChange={(e) => setCity(e.target.value)} 
            className="form-control" 
          />
        </div>
         
       

        {/* Submit Button */}
        <div className="form-group">
          <button onClick={handleSubmit} className="btn btn-primary">Submit</button>
        </div>
      </div>
    </div>
  );
}

export default VehicleRegistration;
