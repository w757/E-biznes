import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Cart = () => {
  const [cart, setCart] = useState({});

  useEffect(() => {
    fetchCart();
  }, []);

  const fetchCart = async () => {
      try {
          const response = await axios.get('http://localhost:8080/cart');
          setCart(response.data);
      } catch (error) {
          console.error('Error fetching cart:', error);
      }
  };

  const renderCartItems = () => {
    return (
      <ul>
        {Object.entries(cart).map(([key, value]) => (
          <li key={key}>
            <strong>{key}:</strong> {JSON.stringify(value)}
          </li>
        ))}
      </ul>
    );
  };

  return (
    <div>
      <h2>Cart</h2>
      {renderCartItems()}
    </div>
  );
};

export default Cart;
