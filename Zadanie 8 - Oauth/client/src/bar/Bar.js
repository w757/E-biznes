import React, { useState, useEffect } from "react";
import { Container, Nav, Navbar } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';

export default function Bar() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const navigate = useNavigate();
  useEffect(() => {
    const accessToken = localStorage.getItem("accessToken");
    if (accessToken) {
      setIsLoggedIn(true);
    } else {
      setIsLoggedIn(false);
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("accessToken");
    setIsLoggedIn(false);
  };

  const handleLogin = () => {
    // Przekierowanie do strony logowania
    navigate("/auth");
  };

  return (
    <Navbar className="navbar">
      <Container>
        <Nav.Link href="/">ZIELONY RAJ dla amatorów</Nav.Link>

        <Navbar.Collapse className="justify-content-end">
          {isLoggedIn ? (
            <Nav.Link onClick={handleLogout}>LOGOUT</Nav.Link>
          ) : (
            <Nav.Link onClick={handleLogin}>LOG IN / SIGN UP</Nav.Link>
          )}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}
