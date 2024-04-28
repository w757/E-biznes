import React, { useState } from "react";
import { Button, Form, Alert } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

export default function SignIn() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(null);
  const [successMessage, setSuccessMessage] = useState(null);
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await fetch("http://localhost:5000/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ username: username, password: password }),
      });

      const responseData = await response.json();

      if (!response.ok) {
        throw new Error(responseData.message || "Login failed");
      }


      // get
      const accessToken = responseData.access_token;

      // Save the access token in cookie
      // document.cookie = `accessToken=${accessToken}; path=/;`;
      document.cookie = `accessToken=${accessToken}; path=/; SameSite=None; Secure;`;



      setSuccessMessage("Login successful!");
      setUsername("");
      setPassword("");

      

      // Redirect to another path after successful login
      navigate("/");
    } catch (error) {
      setError(error.message);
      setSuccessMessage(null);
    }
  };

  const handleOauthLogin = () => {
    // Przekierowanie do strony logowania
    navigate("/oauth");
  };

  return (
    <>
      <div className="submit_form">
        <h2 className="form_title">Sign in</h2>
        {error && <Alert variant="danger">{error}</Alert>}
        {successMessage && <Alert variant="success">{successMessage}</Alert>}
        <Form className="between_fields_spacing" onSubmit={handleSubmit}>
          <Form.Group
            className="between_fields_spacing"
            controlId="username"
          >
            <Form.Label className="text-center">Enter username</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
          </Form.Group>
          <Form.Group
            className="between_fields_spacing"
            controlId="password"
          >
            <Form.Label>Password</Form.Label>
            <Form.Control
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </Form.Group>
          <div className="centered">
            <Button
              variant="big_submit"
              size="lg"
              type="submit"
            >
              SIGN IN
            </Button>
          </div>
        </Form>


        <Form className="between_fields_spacing" onSubmit={handleOauthLogin}>

          <div className="centered">
            <Button
              variant="big_submit"
              size="lg"
              type="submit"
            >
              Log in with Google 
            </Button>
          </div>
        </Form>


      </div>
    </>
  );
}
