// import React, { useState, useEffect } from 'react';
// import { Link } from 'react-router-dom';

// function Profile() {
//   // Initial state with sample profile data
//   const [profile, setProfile] = useState({
//     name: 'John Doe',
//     address: '123 Main St, Springfield',
//     mobileNo: '123-456-7890',
//     city: 'Springfield',
//   });

//   // Here, you can fetch real user data from an API (For now, we're using hardcoded data).
//   useEffect(() => {
//     // Example of fetching profile data from an API (not needed in this case)
//     // const fetchProfileData = async () => {
//     //   const response = await fetch('/api/user/profile');
//     //   const data = await response.json();
//     //   setProfile(data);
//     // };
//     // fetchProfileData();
//   }, []);

//   return (
//     <div className="profile-container">
//       <h2 className="profile-header">Profile Details</h2>
//       <div className="profile-info">
//         <div className="profile-item">
//           <strong>Name: </strong>
//           <span>{profile.name}</span>
//         </div>
//         <div className="profile-item">
//           <strong>Address: </strong>
//           <span>{profile.address}</span>
//         </div>
//         <div className="profile-item">
//           <strong>Mobile No: </strong>
//           <span>{profile.mobileNo}</span>
//         </div>
//         <div className="profile-item">
//           <strong>City: </strong>
//           <span>{profile.city}</span>
//         </div>
//       </div>

//       <div className="profile-actions">
//         <Link to="/edit-profile" className="btn btn-warning">
//           Edit Profile
//         </Link>
//       </div>
//     </div>
//   );
// }

// export default Profile;

//new code
import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

function Profile() {
  // Sample profile data with image URL
  const [profile, setProfile] = useState({
    name: 'John Doe',
    address: '123 Main St, Springfield',
    mobileNo: '123-456-7890',
    city: 'Springfield',
    imageUrl: 'https://via.placeholder.com/150', // Placeholder image URL
  });

  // Simulating an API call or fetching user data
  useEffect(() => {
    // You can replace this with an actual fetch request
  }, []);

  return (
    <div className="profile-container">
      <h2 className="profile-header">Profile Details</h2>

      {/* Profile Image */}
      {/* <div className="profile-image-container">
        <img
          src={profile.imageUrl}
          alt="Profile"
          className="profile-image"
        />
      </div> */}
      { <div className="text-center mb-4">
            <img src={require('../screens/image/img.jpg')} width={90} height={60} alt='Logo' className='logo' />
          </div> }

      {/* Profile Information */}
      <div className="profile-info">
        <div className="profile-item">
          <strong>Name: </strong>
          <span>{profile.name}</span>
        </div>
        <div className="profile-item">
          <strong>Address: </strong>
          <span>{profile.address}</span>
        </div>
        <div className="profile-item">
          <strong>Mobile No: </strong>
          <span>{profile.mobileNo}</span>
        </div>
        <div className="profile-item">
          <strong>City: </strong>
          <span>{profile.city}</span>
        </div>
      </div>

      {/* Edit Profile Button */}
      <div className="profile-actions">
        <Link to="/edit-profile" className="btn btn-warning">
          Edit Profile
        </Link>
      </div>
    </div>
  );
}

export default Profile;
