import React, { useState, useEffect } from "react";
import useGetRequest from "../api/Requests";
import { useNavigate } from "react-router-dom"; // Używamy useNavigate zamiast useHistory

export default function ProductDescription(props) {
  const [newComment, setNewComment] = useState("");
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const data = useGetRequest(`http://localhost:5000/products/${props["id"]}`);
  const navigate = useNavigate(); // Używamy useNavigate

  useEffect(() => {
    const token = localStorage.getItem("access_token");
    if (token) {
      setIsLoggedIn(true);
    }
  }, []);

  const handleAddComment = () => {
    if (!isLoggedIn) {
      alert("Musisz być zalogowany, aby dodać komentarz.");
      return;
    }
    console.log("Dodawanie komentarza:", newComment);
    setNewComment("");
  };

  const handleLoginRedirect = () => {
    // Przekierowanie do strony logowania po kliknięciu przycisku
    navigate("/login");
  };

  if (!data) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <h1>{data["name"]}</h1>
      <h2>{data["description"]}</h2>
      <h3>Comments:</h3>
      {Array.isArray(data["comments"]) && data["comments"].length > 0 ? (
        <ul style={{ listStyleType: "none", padding: 0 }}>
          {data["comments"].map((comment) => (
            <li
              key={comment.id}
              style={{ marginBottom: "10px", padding: "10px", border: "1px solid #ccc" }}
            >
              <p>{comment.text}</p>
              <p>User ID: {comment.user_id}</p>
            </li>
          ))}
        </ul>
      ) : (
        <p>{data["comments"]}</p>
      )}

      {/* Komunikat i przycisk przekierowujący do logowania */}
      {!isLoggedIn && (
        <div>
          <p>Musisz być zalogowany, aby dodać komentarz.</p>
          <button onClick={handleLoginRedirect}>Zaloguj się</button>
        </div>
      )}

      {/* Przycisk do dodawania nowego komentarza */}
      {isLoggedIn && (
        <div style={{ marginTop: "20px" }}>
          <textarea
            rows="4"
            cols="50"
            value={newComment}
            onChange={(e) => setNewComment(e.target.value)}
            placeholder="Wpisz swój komentarz..."
            style={{ marginBottom: "10px" }}
          />
          <br />
          <button onClick={handleAddComment}>Dodaj komentarz</button>
        </div>
      )}
    </>
  );
}
