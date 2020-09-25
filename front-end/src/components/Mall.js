import React, { Component } from 'react';
import MallProduct from './MallProduct'

class Mall extends Component {
    state={
        data:[]
    }
    componentDidMount() {
        console.log("didmount");
        let url="http://localhost:8080/product/list";
        // const response = await fetch(url);
        // const data = await response.json();
        // console.log(data);
        this.fetchData(url)
        .then(result => {
            console.log(result)
            //document.writeln(result);
            this.setState({data:result});
        })
        .catch(error => {
            console.error(error);
        });
    }
    fetchData=(url)=> {
        // <-- start
        // TODO 23: 通过Fetch API实现异步请求
        // end -->
        return fetch(url)
          .then(function(response) {
            return response.json();
          })
          .catch(function(e) {
            return e;
          });
      }
  render() {
    return (
        <ul>
          <h1>Mall</h1>
          {this.state.data.map((item, index) => (
                <MallProduct key={index + 1} value={item} />
            ))}
        </ul>
      );
    
    // console.log("render");
    // return <h1>MALL</h1>
  }
}

export default Mall;