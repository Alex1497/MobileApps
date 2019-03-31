import React, { Component } from 'react';
import {TextInput, Button, Text, View } from 'react-native';

export default class App extends React.Component {

  //States are first defined in a constructor of props
  constructor(props){
    super(props);

    //We define the initial state
    this.state = {
      firstInput: "",
      secondInput:"",
      stateChanged: false
    }

  }


  //Definition of a method we want to trigger when the state changes
  displayResult(){

    //We validate if the input changed
    if(this.state.firstInput !== "" && this.state.secondInput !== ""){

      //If so, we change the stateChanged flag
      this.setState({stateChanged: true});
    }

    else{
      this.setState({stateChanged: false});
    }
  }

  render() {
    return (
        <View>
        <View>
        <Text >Enter your name</Text>
    <TextInput onChangeText={(inputValue) => this.setState({firstInput: inputValue})}  />
    </View>
    <View>
    <Text >Enter your last name</Text>
    <TextInput onChangeText={(inputValue) => this.setState({secondInput: inputValue})}  />
    </View>

    <View>
    <Button onPress={() => {this.displayResult()}} title="Press Here"  />
        </View>

        <View >
        <Text > {this.state.stateChanged ? this.state.firstInput : "" } </Text>
        <Text > {this.state.stateChanged ? this.state.secondInput : "" } </Text>
        </View>

        </View>
  );
  }
}

