import React, {Component} from 'react';
import { BrowserRouter, NavLink, Route } from 'react-router-dom';
import Mall from './Mall';
import Order from './Order';
import AddProduct from './AddProduct';


class Home extends Component {
  
  render() {
    return (
    
    <BrowserRouter>
        <h1>TOP</h1>
        <NavLink className="link" exact to="/" activeStyle={{
                textDecoration: "underline",
              }}>商城</NavLink>
        <NavLink className="link" exact to="/order" activeStyle={{
                textDecoration: "underline",
              }}>订单</NavLink>
        <NavLink className="link" exact to="/add-product" activeStyle={{
                textDecoration: "underline",
              }}>+添加商品</NavLink>
        <Route exact path="/" component={Mall}/>
        <Route exact path="/order" component={Order}/>
        <Route exact path="/add-product" component={AddProduct}/>
      </BrowserRouter>
    );
  }
}

export default Home;


