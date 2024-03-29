import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Cart = () => {
  const [cart, setCart] = useState({});
  const [paymentStatus, setPaymentStatus] = useState('');
  const [paymentDetails, setPaymentDetails] = useState(null);

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

  const checkPaymentStatus = async (paymentId) => {
    try {
      const response = await axios.get(`http://localhost:8080/payment/${paymentId}`);
      setPaymentStatus(response.data.status);
      setPaymentDetails(response.data);
    } catch (error) {
      console.error('Error checking payment status:', error);
    }
  };

  const handleCheckPaymentStatus = () => {
    if (cart.PaymentID) {
      checkPaymentStatus(cart.PaymentID.toString());
    }
  };

  const renderCartItems = () => {
    if (!cart.Items || cart.Items.length === 0) {
      return (
        <div>
          <h3>Cart Details</h3>
          <p>ID: {cart.ID}</p>
          <p>PaymentID: {cart.PaymentID}</p>
          <p>No items in the cart</p>
        </div>
      );
    }
  
    return (
      <div>
        <h3>Cart Details</h3>
        {/* <p>ID: {cart.ID}</p>
        <p>PaymentID: {cart.PaymentID}</p> */}
        <h3>Cart Items</h3>
        <ul>
          {cart.Items.map((item, index) => (
            <li key={index}>
              <strong>Name:</strong> {item.Name}, <strong>Price:</strong> {item.Price}
              {item.Category && <><strong>, Category:</strong> {item.Category.Name}</>}
            </li>
          ))}
        </ul>
      </div>
    );
  };
  
  const renderPaymentDetails = () => {
    if (!paymentDetails) return null;

    return (
      <div>
        <h3>Payment Details</h3>
        <p>Status: {paymentDetails.Status}</p>
      </div>
    );
  };

  return (
    <div>
      <h2>Cart</h2>
      {renderCartItems()}
      <button onClick={handleCheckPaymentStatus}>Check Payment Status</button>
      {paymentStatus && <p>Payment Status: {paymentStatus}</p>}
      {renderPaymentDetails()}
    </div>
  );
};

export default Cart;
