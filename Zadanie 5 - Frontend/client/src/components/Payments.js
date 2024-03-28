import React, { useState } from 'react';
import axios from 'axios';

const Payments = () => {
  const [cardNumber, setCardNumber] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const paymentData = {
      cardNumber: cardNumber
    };
    axios.post('http://localhost:8080/payment', paymentData)
      .then(response => {
        console.log('Payment successful:', response.data);
      })
      .catch(error => {
        console.error('Payment error:', error);
      });
  };

  const handleChange = (e) => {
    setCardNumber(e.target.value);
  };

  return (
    <div>
      <h2>Payments</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Card Number:
          <input type="text" value={cardNumber} onChange={handleChange} />
        </label>
        <button type="submit">Pay</button>
      </form>
    </div>
  );
};

export default Payments;
