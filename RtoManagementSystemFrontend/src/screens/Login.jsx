import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import './login.css';
import axios from "axios";


function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  
  const navigate = useNavigate();

  // const onLogin = () => {
  //   if (username.length === 0) {
  //     toast.warn("Please enter your username");
  //   } else if (password.length === 0) {
  //     toast.warn("Please enter your password");
  //   } else {
  //     // Handle login logic here, for now, we simulate success.
  //     toast.success("Successfully logged in!");
  //     // Redirect to another page after login (for example: dashboard)
  //     navigate("/home");
  //   }
  // };

  const onLogin = async () => {
    if (email.length === 0) {
      toast.warn("Please enter your email");
    } else if (password.length === 0) {
      toast.warn("Please enter your password");
    } else {
      try {
        const response = await axios.post("http://localhost:8080/users/signIn", {
          email,
          password,
        });
  
        toast.success("Successfully logged in!");
        localStorage.setItem("token", response.data.token);
        navigate("/home");
      } catch (error) {
        toast.error("Invalid EmailId or password");
        console.error("Login error:", error);
      }
    }
  };

  return (
    <div className="login-container">
      <h2 className="login-header">Login</h2>
      <div className="login-form">
        <div className="mb-3">
          <label htmlFor="email" className="form-label">
            Email
          </label>
          <input
            type="text"
            id="username"
            className="form-control"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Enter your username"
          />
        </div>

        <div className="mb-3">
          <label htmlFor="password" className="form-label">
            Password
          </label>
          <input
            type="password"
            id="password"
            className="form-control"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter your password"
          />
        </div>

        <div className="d-flex justify-content-between mb-3">
          <button
            onClick={onLogin}
            className="btn btn-primary"
          >
            Login
          </button>
          <div>
            Don't have an account? <Link to="/register">Sign Up</Link>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
