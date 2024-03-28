import React, { useState } from 'react';
import axios from 'axios';

const Payments = () => {
  const [paymentId, setPaymentId] = useState('');
  const [paymentStatus, setPaymentStatus] = useState('');
  const [paymentData, setPaymentData] = useState(null);
  const [error, setError] = useState('');

  const fetchPaymentStatus = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/payment/${paymentId}?status=${paymentStatus}`);
      setPaymentData(response.data);
      setError('');
    } catch (error) {
      setPaymentData(null);
      setError('Error fetching payment data');
    }
  };

  return (
    <div>
      <h2>Payments</h2>
      <div>
        <label htmlFor="paymentId">Payment ID:</label>
        <input type="text" id="paymentId" value={paymentId} onChange={(e) => setPaymentId(e.target.value)} />
      </div>
      <div>
        <label htmlFor="paymentStatus">Payment Status:</label>
        <input type="text" id="paymentStatus" value={paymentStatus} onChange={(e) => setPaymentStatus(e.target.value)} />
      </div>
      <button onClick={fetchPaymentStatus}>Check Payment Status</button>
      {error && <p>{error}</p>}
      {paymentData && (
        <div>
          <p>Payment ID: {paymentData.ID}</p>
          <p>Amount: {paymentData.Amount}</p>
          <p>Status: {paymentData.Status}</p>
        </div>
      )}
    </div>
  );
};

export default Payments;
