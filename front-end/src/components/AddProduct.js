import React, { Component } from 'react';

class AddProduct extends Component {
    state={name:"",
            unitPrice:"",
            unit:"",
            img:"",
            }
    change=function(e,inputid){
        this.setState({[inputid]:e.target.value});
        }
    submit=()=>{
        alert(JSON.stringify(this.state));
    }
  render() { 
      return (<form>
    <h1>Home</h1>
    <div class="form-group">
      <label htmlFor="name">名称:</label>
      <input className="form-control" id="name" value={this.state.name} onChange={(e) =>this.change(e,"name")}></input>
    </div>
    <div class="form-group">
      <label htmlFor="gender">价格:</label>
      <input className="form-control" id="unitPrice" value={this.state.unitPrice} onChange={(e) =>this.change(e,"unitPrice")}></input>
    </div>
    <div class="form-group">
      <label htmlFor="description">单位：</label>
      <input className="form-control" id="unit" value={this.state.unit} onChange={(e) =>this.change(e,"unit")}></input>
    </div>
    <div class="form-group">
      <label htmlFor="description">图片：</label>
      <input className="form-control" id="img" value={this.state.img} onChange={(e) =>this.change(e,"img")}></input>
    </div>
    <button type="button" onClick={this.submit} disabled={(this.state.name===''||this.state.gender===''||this.state.description==='')} className="btn btn-primary">Submit</button>
  </form>)
       ;
  }
}

export default AddProduct;