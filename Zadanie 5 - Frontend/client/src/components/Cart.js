import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Cart = () => {
  const [cart, setCart] = useState({});

  useEffect(() => {
    axios.get('http://localhost:8080/cart')
      .then(response => {
        setCart(response.data);
      })
      .catch(error => {
        console.error('Error fetching cart:', error);
      });
  }, []);

  return (
    <div>
      <h2>Cart</h2>
      {/* Display cart items */}
      <ul>
        {cart.Items && cart.Items.map(item => (
          <li key={item.ID}>{item.Name}</li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;
