import React from "react";

function LandingPage() {
  return (
    <div className="page-container">
      <div className="card">
        <h1 className="card-title">AI-Powered Career Counseling Platform</h1>
        <p className="card-subtitle">
          A student-built platform that combines mentors and AI to help
          university students plan their careers.
        </p>

        <p>
          This is the landing page of your Software Engineering course project.
          From here, students will be able to sign up, create their profiles,
          and request AI-generated career advice.
        </p>

        <div className="btn-group">
          <button className="btn-primary">Get Started</button>
          <button className="btn-secondary">Learn More</button>
        </div>
      </div>
    </div>
  );
}

export default LandingPage;
