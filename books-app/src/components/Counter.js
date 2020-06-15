
import React, { Component } from 'react'

 class Counter extends Component {
     constructor(props) {
       super(props)
     
       this.state = {
          count: 0
       }
     }
     
      incrementCount=()=>{
       //  alert("hello");
       this.setState(prevState =>{
        return {count : prevState.count +1}
    })
     }
  render() {
    return (
      <React.Fragment>
          <h3> you have clicked {this.state.count}times </h3> 
     <button onClick ={this.incrementCount}> Clicked Me</button>
      </React.Fragment>
    )
  }
}

export default Counter

