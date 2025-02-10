import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
//import axios from "axios";

function Register() {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [dob, setDob] = useState("");
  const [phone, setPhone] = useState("");
   const [city, setCity] = useState("");
   const [state, setState] = useState("");
   const [gender, setGender] = useState("");
   const [bloodGroup, setBloodGroup] = useState("");
   const [address, setAddress] = useState("");


  


  const navigate = useNavigate();
  const onSignup = async () => {
    if (firstName.length === 0) {
      toast.warn("Please enter first name");
    } else if (lastName.length === 0) {
      toast.warn("Please enter last name");
    } else if (email.length === 0) {
      toast.warn("Please enter email");
    } else if (phone.length === 0) {
      toast.warn("Please enter phone number");
    } else if (password.length === 0) {
      toast.warn("Please enter password");
    } else if (confirmPassword.length === 0) {
      toast.warn("Please confirm password");
    } else if (password !== confirmPassword) {
      toast.warn("Password does not match");
    } else {
      // API request
      const user = {
        firstName,
        lastName,
        email,
        password,
        dob,
        phone,
        city,
        state,
        gender,
        bloodGroup,
        address,

      };
  
      try {
        const response = await fetch("http://localhost:8080/addUser/add", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(user),
        });
  
        const result = await response.json();
  
        if (response.ok) {
          toast.success("Successfully registered a new admin");
          navigate("/login"); 
        } else {
          toast.error(result.message || "Registration failed");
        }
      } catch (error) {
        toast.error("Server error: Unable to register");
      }
    }
  };
  
  return (
    <div
      className="card shadow-lg p-4 rounded"
      style={{
        width: "100%",
        marginTop: "0px",
        marginLeft: "-10%",
        marginRight: "-50%",
      }}
    >
      <h2 className="header text-center">Registration Form</h2>
      <div className="row">
        <div className="col-md-1"></div>
        <div className="col">
          <div className="row">
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="firstName"
                  onChange={(e) => setFirstName(e.target.value)}
                  type="text"
                  placeholder="First Name"
                  className="form-control"
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="lastName"
                  onChange={(e) => setLastName(e.target.value)}
                  type="text"
                  placeholder="Last Name"
                  className="form-control"
                />
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="email"
                  onChange={(e) => setEmail(e.target.value)}
                  type="email"
                  placeholder="Email"
                  className="form-control"
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="phone"
                  onChange={(e) => setPhone(e.target.value)}
                  type="tel"
                  placeholder="Phone Number"
                  className="form-control"
                />
              </div>
            </div>
          </div>
           
          <div className="row">
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="city"
                  onChange={(e) => setCity(e.target.value)}
                  type="city"
                  placeholder="city"
                  className="form-control"
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-4">
                {/* <input
                  id="state"
                  onChange={(e) => setState(e.target.value)}
                  type="tel"
                  placeholder="state"
                  className="form-control"
                /> */}
                  <select
              id="gender"
              onChange={(e) => setState(e.target.value)}
              className="form-control"
    >
      <option value="">Select State</option>
<option value="Andhra Pradesh">Andhra Pradesh</option>
<option value="Arunachal Pradesh">Arunachal Pradesh</option>
<option value="Assam">Assam</option>
<option value="Bihar">Bihar</option>
<option value="Chhattisgarh">Chhattisgarh</option>
<option value="Goa">Goa</option>
<option value="Gujarat">Gujarat</option>
<option value="Haryana">Haryana</option>
<option value="Himachal Pradesh">Himachal Pradesh</option>
<option value="Jharkhand">Jharkhand</option>
<option value="Karnataka">Karnataka</option>
<option value="Kerala">Kerala</option>
<option value="Madhya Pradesh">Madhya Pradesh</option>
<option value="Maharashtra">Maharashtra</option>
<option value="Manipur">Manipur</option>
<option value="Meghalaya">Meghalaya</option>
<option value="Mizoram">Mizoram</option>
<option value="Nagaland">Nagaland</option>
<option value="Odisha">Odisha</option>
<option value="Punjab">Punjab</option>
<option value="Rajasthan">Rajasthan</option>
<option value="Sikkim">Sikkim</option>
<option value="Tamil Nadu">Tamil Nadu</option>
<option value="Telangana">Telangana</option>
<option value="Tripura">Tripura</option>
<option value="Uttar Pradesh">Uttar Pradesh</option>
<option value="Uttarakhand">Uttarakhand</option>
<option value="West Bengal">West Bengal</option>

    </select>
              </div>
            </div>
          </div>

          <div className="row">
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="password"
                  onChange={(e) => setPassword(e.target.value)}
                  type="password"
                  placeholder="Password"
                  className="form-control"
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="confirmPassword"
                  onChange={(e) => setConfirmPassword(e.target.value)}
                  type="password"
                  placeholder="ConfirmPassword"
                  className="form-control"
                />
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="dob"
                  onChange={(e) => setDob(e.target.value)}
                  type="date"
                  placeholder="Date of Birth"
                  className="form-control"
                />
              </div>
            </div>
            <div className="col-md-6">
              <div className="mb-4">
              <select
              id="gender"
              onChange={(e) => setGender(e.target.value)}
              className="form-control"
    >
      <option value="">Select Gender</option>
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      <option value="Other">Other</option>
    </select>
              </div>
            </div>
          </div>


          <div className="row">
            <div className="col-md-6">
              <div className="mb-4">
                {/* <input
                  id="bloodGroup"
                  onChange={(e) => setBloodGroup(e.target.value)}
                  type="bloodGroup"
                  placeholder="BloodGroup"
                  className="form-control"
                /> */}
                 <select
              id="gender"
              onChange={(e) => setBloodGroup(e.target.value)}
              className="form-control"
    >
      <option value="">Select Blood Group</option>
<option value="O+">O+</option>
<option value="O-">O-</option>
<option value="A+">A+</option>
<option value="A-">A-</option>
<option value="B+">B+</option>
<option value="B-">B-</option>
<option value="AB+">AB+</option>
<option value="AB-">AB-</option>
    </select>
              </div>
            </div>

            <div className="col-md-6">
              <div className="mb-4">
                <input
                  id="address"
                  onChange={(e) => setAddress(e.target.value)}
                  type="Address"
                  placeholder="Address"
                  className="form-control"
                />
              </div>
            </div>
           </div>
        
          <div className="text-center">
            <div className="mb-4">
              Already have an account? <Link to="/login">Signin here</Link>
            </div>
            <button onClick={onSignup} className="mt-3 btn btn-success">
              Register
            </button>
          </div>
        </div>
        <div className="col-md-1"></div>
      </div>
    </div>
  );
}
export default Register;