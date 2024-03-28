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
          console.error('Error fetching products:', error);
      }
  };

  return (
    <div>
      <h2>Cart</h2>
      {/* <ul>
        {cart.Items && cart.Items.map(item => (
          <li key={item.ID}>{item.Name}</li>
        ))}
      </ul> */}
    </div>
  );
};

export default Cart;
