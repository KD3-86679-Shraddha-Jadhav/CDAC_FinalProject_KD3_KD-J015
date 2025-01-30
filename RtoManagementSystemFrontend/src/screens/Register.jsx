//import './register.css';
import { useState } from "react"
import { Link,useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'

//import { signup } from '../services/admin'


function Register(){
    const [firstName, setFirstName] = useState('John');
    const [lastName, setLastName] = useState('Doe');
    const [gender, setGender] = useState('Male');
    const [dateOfBirth, setDOB] = useState('1990-01-01');
    const [address, setAddress] = useState('123 Main St, Mumbai');
    
    const [email, setEmail] = useState('john.doe@example.com');
    const [city, setCity] = useState('Mumbai');
    const [state, setState] = useState('Maharashtra');
    const [bloodGroup, setBloodGroup] = useState('O+');
    const [password, setPassword] = useState('pass123');
    
    const [confirmPassword, setConfirmPassword] = useState('pass123');
    const [phone, setPhone] = useState('1234567890');
    
    //get navigate function
    const navigate = useNavigate()
     
    const onSignup =  () => {
        if(firstName.length == 0) {
            toast.warn('please enter first name')
        }else if (lastName.length == 0) {
            toast.warn('Please eneter last name')
        }else if (gender.length == 0) {
            toast.warn('Please eneter your gender')
        }else if (dateOfBirth.length == 0) {
            toast.warn('Please eneter dateOfBirth')
        }else if (address.length == 0) {
            toast.warn('Please eneter your Address')
        }else if (email.length == 0) {
            toast.warn('Please eneter email')
        }else if (city.length == 0) {
            toast.warn('Please eneter your city')
        }else if (state.length == 0) {
            toast.warn('Please eneter your State')
        }else if (bloodGroup.length == 0) {
            toast.warn('Please eneter your Blood Group')
        }else if (phone.length == 0) {
            toast.warn('Please eneter phone number')
        }else if (password.length == 0) {
            toast.warn('Please eneter password')
        }else if (confirmPassword.length == 0) {
            toast.warn('Please confirm passwrod')
        }else if (password != confirmPassword) {
            toast.warn('password does not match')
        // } else {
        //     const result =  signup(firstName,lastName,email,password,phone)
        //      if (result['status'] == 'success') {
        //         toast.success('Successfully registered a new admin')

        //         //go back
        //         navigate(-1) 
        //     } else {
        //         toast.error(result['error'])
        //     }
        
        }
        
    }

    return(
    <div>
        <h2 className='header'>Registeration Form</h2>

        <div className="row">
            <div className="col"></div>
            <div className='col'>
          <div className='mb-3'>
            <label htmlFor=''>First Name</label>
            <input
              onChange={(e) => setFirstName(e.target.value)}
              type='text'
              className='form-control'
            />
          </div>
          <div className="mb-3">
            <label htmlFor="">Last Name</label>
            <input 
            onChange={(e)=> setLastName(e.target.value)}
            type="text" 
            className="form-control"/>
          </div>
          <div className="mb-3">
                        <label htmlFor="">Gender</label>
                        <select
                            value={gender}
                            onChange={(e) => setGender(e.target.value)}
                            className="form-control"
                        >
                            <option value="">Select Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
          <div className="mb-3">
            <label htmlFor="">Date-Of-Birth</label>
            <input 
            onChange={(e)=>setDOB(e.target.value)}
            type="dob"
            className="form-control" />
          </div>
          <div className="mb-3">
            <label htmlFor="">Address</label>
            <input 
            onChange={(e)=>setAddress(e.target.value)}
            type="text"
            className="form-control" />
          </div>
          <div className="mb-3">
            <label htmlFor="">Email</label>
            <input 
            onChange={(e)=>setEmail(e.target.value)}
            type="email"
            className="form-control" />
          </div>
          <div className="mb-3">
            <label htmlFor="">City</label>
            <input 
            onChange={(e)=>setCity(e.target.value)}
            type="text"
            className="form-control" />
          </div>
          <div className="mb-3">
            <label htmlFor="">State</label>
            <input 
            onChange={(e)=>setState(e.target.value)}
            type="text"
            className="form-control" />
          </div>
          <div className="mb-3">
            <label htmlFor="">Blood Group</label>
            <input 
            onChange={(e)=>setBloodGroup(e.target.value)}
            type="text"
            className="form-control" />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Phone Number</label>
            <input
              onChange={(e) => setPhone(e.target.value)}
              type='tel'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Password</label>
            <input
              onChange={(e) => setPassword(e.target.value)}
              type='password'
              className='form-control'
            />
          </div>
          <div className='mb-3'>
            <label htmlFor=''>Confirm Password</label>
            <input
              onChange={(e) => setConfirmPassword(e.target.value)}
              type='password'
              className='form-control'
            />
          </div>

          <div className='mb-3'>
            <div>
              Already have an account? <Link to='/login'>Signin here</Link>
            </div>
            <button onClick={onSignup} className='mt-3 btn btn-success'>
              Signup
            </button>
          </div>
          <div className='mb-3'>
            <div>
              RegisterYourVehicle? <Link to='/VehicleRegisteration'>Register here</Link>
            </div>
            
          </div>
         <div className="col"></div>
        </div>
    </div>
    </div>
    )
}

export default Register