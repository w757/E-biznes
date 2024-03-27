import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Products from './components/Products';
import Payments from './components/Payments';
import Cart from './components/Cart';

const App = () => {
  return (
    <Router>
      <div>
        <Switch>
          <Route path="/" exact component={Products} />
          <Route path="/payments" component={Payments} />
          <Route path="/cart" component={Cart} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;
