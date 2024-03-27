import React from 'react'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Products from './components/ProductList';
import Payments from './components/Payments';
import Cart from './components/Cart';
import axios from 'axios'; // Importuj axios
import ProductList from './components/ProductList';

const App = () => {
  return (
    <Router>
      <div>
        <Switch>
          <Route path="/products" component={ProductList} />
          <Route path="/payments" component={Payments} />
          <Route path="/cart" component={Cart} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;



