import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import './login.css';

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  
  const navigate = useNavigate();

  const onLogin = () => {
    if (username.length === 0) {
      toast.warn("Please enter your username");
    } else if (password.length === 0) {
      toast.warn("Please enter your password");
    } else {
      // Handle login logic here, for now, we simulate success.
      toast.success("Successfully logged in!");
      // Redirect to another page after login (for example: dashboard)
      navigate("/home");
    }
  };

  return (
    <div className="login-container">
      <h2 className="login-header">Login</h2>
      <div className="login-form">
        <div className="mb-3">
          <label htmlFor="username" className="form-label">
            Username
          </label>
          <input
            type="text"
            id="username"
            className="form-control"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
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
