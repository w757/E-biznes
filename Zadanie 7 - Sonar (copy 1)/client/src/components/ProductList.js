import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ProductList = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        fetchProducts();
    }, []);

    const fetchProducts = async () => {
        try {
            const response = await axios.get('http://localhost:8080/products');
            setProducts(response.data);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
    };


    
    return (
        <div>
            <h2>Products</h2>
            <ul>
                {products.map(product => (
                    <li key={product.ID}>
                        <h3>{product.Name}</h3>
                        <p>Price: ${product.Price}</p>
                        {product.Category && <p>Category: {product.Category.Name}</p>}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ProductList;
