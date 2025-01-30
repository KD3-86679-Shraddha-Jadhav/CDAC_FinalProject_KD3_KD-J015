import { Link, useNavigate } from "react-router-dom"

function Navbar() {
    //get navigate function
    const navigate = useNavigate()

     const onLogout = () => {
    //     //clear the session storage
    //     sessionStorage.removeItem('name')
    //     sessionStorage.removeItem('token')
    //     sessionStorage.removeItem('email')
    //     sessionStorage.removeItem('phone')

        //go to login screen
        navigate('/login')
        
    }
    return ( 
        <nav className='navbar navbar-expand-lg bg-primary' data-bs-theme='dark'>
      <div className='container-fluid'>
        <a className='navbar-brand' href='#'>
          RtoManagementSystem 
        </a>
        <button
          className='navbar-toggler'
          type='button'
          data-bs-toggle='collapse'
          data-bs-target='#navbarNav'
          aria-controls='navbarNav'
          aria-expanded='false'
          aria-label='Toggle navigation'
        >
          <span className='navbar-toggler-icon'></span>
        </button>
        <div className='collapse navbar-collapse' id='navbarNav'>
          <ul className='navbar-nav'>
            <li className='nav-item'>
              <Link className='nav-link' aria-current='page' to='/Register'>
                Registeration
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' aria-current='page' to='/VehicleRegisteration'>
                VehicleRegisteration
              </Link>
            </li>
            {/* <li className='nav-item'>
              <Link className='nav-link' to='/Login'>
                Login
              </Link>
            </li> */}
            <li className='nav-item'>
              <Link className='nav-link' to='/Profile'>
                Profile
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/Appointment'>
                AppointmentForSlotbooking
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/ApplyForTest'>
                ApplyForTest
              </Link>
            </li>
            <li className='nav-item'>
              <Link className='nav-link' to='/GetResult'>
                GetTestResult
              </Link>
            </li>

            <li className='nav-item'>
              <button onClick={onLogout} className='nav-link'>
                Logout
              </button>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  
     );
}

export default Navbar;