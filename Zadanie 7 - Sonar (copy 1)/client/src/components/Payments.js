import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Payment = () => {
  const { id } = useParams();
  const [paymentData, setPaymentData] = useState(null);
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchPaymentStatus = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/payment/${id}`);
        setPaymentData(response.data);
        setError('');
      } catch (error) {
        setPaymentData(null);
        if (error.response && error.response.status === 404) {
          setError('Payment not found');
        } else {
          setError('Error fetching payment data');
        }
      }
    };

    fetchPaymentStatus();
  }, [id]);

  return (
    <div>
      <h2>Payment Details</h2>
      {error && <p>{error}</p>}
      {paymentData && (
        <div>
          <p>Payment ID: {paymentData.ID}</p>
          <p>Status: {paymentData.Status}</p>
        </div>
      )}
    </div>
  );
};

export default Payment;
