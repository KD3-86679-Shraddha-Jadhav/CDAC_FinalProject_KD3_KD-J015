

// export default Maintainuser;
import React, { useState, useEffect } from 'react';
import './Maintainuser.css'; // Import the CSS file for styling

const Maintainuser = () => {
  const [users, setUsers] = useState([]); // State to store users
  const [newUser, setNewUser] = useState({ name: '', email: '' }); // State for adding a new user
  const [editUser, setEditUser] = useState(null); // State for editing a user

  // Fetch user data (in a real app, this would be from an API)
  useEffect(() => {
    const fetchUsers = async () => {
      const userData = [
        { id: 1, name: 'John Doe', email: 'john@example.com' },
        { id: 2, name: 'Jane Smith', email: 'jane@example.com' },
      ];
      setUsers(userData);
    };
    fetchUsers();
  }, []);

  // Add a new user
  const handleAddUser = () => {
    setUsers([...users, { id: users.length + 1, ...newUser }]);
    setNewUser({ name: '', email: '' });
  };

  // Edit a user's details
  const handleEditUser = () => {
    setUsers(users.map((user) => (user.id === editUser.id ? editUser : user)));
    setEditUser(null);
  };

  // Delete a user
  const handleDeleteUser = (id) => {
    setUsers(users.filter((user) => user.id !== id));
  };

  return (
    <div className="container">
      <h2>User Management</h2>

      {/* Add User Form */}
      <div className="form-section">
        <h3>Add New User</h3>
        <input
          type="text"
          placeholder="Name"
          value={newUser.name}
          onChange={(e) => setNewUser({ ...newUser, name: e.target.value })}
          className="input"
        />
        <input
          type="email"
          placeholder="Email"
          value={newUser.email}
          onChange={(e) => setNewUser({ ...newUser, email: e.target.value })}
          className="input"
        />
        <button onClick={handleAddUser} className="button">
          Add User
        </button>
      </div>

      {/* Edit User Form */}
      {editUser && (
        <div className="form-section">
          <h3>Edit User</h3>
          <input
            type="text"
            value={editUser.name}
            onChange={(e) => setEditUser({ ...editUser, name: e.target.value })}
            className="input"
          />
          <input
            type="email"
            value={editUser.email}
            onChange={(e) => setEditUser({ ...editUser, email: e.target.value })}
            className="input"
          />
          <button onClick={handleEditUser} className="button">
            Save Changes
          </button>
          <button onClick={() => setEditUser(null)} className="button cancel">
            Cancel
          </button>
        </div>
      )}

      {/* User List */}
      <div>
        <h3>User List</h3>
        <ul className="user-list">
          {users.map((user) => (
            <li key={user.id} className="user-item">
              <span>{user.name} - {user.email}</span>
              <button onClick={() => setEditUser(user)} className="button">
                Edit
              </button>
              <button
                onClick={() => handleDeleteUser(user.id)}
                className="button delete"
              >
                Delete
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
};

export default Maintainuser;
