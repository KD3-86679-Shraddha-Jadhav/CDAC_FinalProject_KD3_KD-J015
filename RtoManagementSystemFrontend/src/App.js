//import logo from './logo.svg';
import './screens/login.css';
import './App.css';
import { Route,Routes } from 'react-router-dom';
import Login from './screens/Login'
import Register from './screens/Register';
import 'react-toastify/dist/ReactToastify.css'
import { ToastContainer } from 'react-toastify';
import Profile from './screens/Profile';
//import Login from './screens/Login';
import Home from './screens/Home';
import ApplyForTest from './screens/ApplyForTest';
import GetResult from './screens/GetResult';
import Appointment from './screens/Appointment';
import VehicleRegisteration from './screens/VehicleRegisteration';
import ApplyForLL from './screens/ApplyForLL';
import ApplyForDL from './screens/ApplyForDL';
import Maintainuser from "./screens/Maintainuser";
import QuizApp from "./screens/QuizApp";




function App() {
  return (
    <div className="App">
      <Routes>
      <Route path='/' element={<Login />} />
      <Route path='login' element={<Login />} />
        <Route path='register'element={<Register/>}/>
        <Route path='profile'element={<Profile/>}/>
        <Route path='home'element={<Home/>}/>
        <Route path='ApplyForTest'element={<ApplyForTest/>}/>
        <Route path='GetResult'element={<GetResult/>}/>
        <Route path='Appointment'element={<Appointment/>}/>
        <Route path='VehicleRegisteration'element={<VehicleRegisteration/>}/>
        <Route path="/ApplyForLL" element={< ApplyForLL/>} />
      <Route path="/ApplyForDL" element={<ApplyForDL/>} /> 
      <Route path="/Maintainuser" element={<Maintainuser/>} /> 
      <Route path="/QuizApp" element={< QuizApp />}/>
      </Routes> 


      <ToastContainer/>
    </div>
  );
}

export default App;
