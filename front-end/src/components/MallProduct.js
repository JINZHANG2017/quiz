import React, { Component } from 'react';

class MallProduct extends Component {
  render() {
    return <ul>
    <h3>{this.props.value.name}</h3>
    <div>{this.props.value.unitPrice}</div>
    <div>{this.props.value.unit}</div>
    <div>{this.props.value.img}</div>
    <button>add to order</button>
  </ul>;
  }
}

export default MallProduct;