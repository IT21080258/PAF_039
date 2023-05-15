import React, {Component} from 'react';
import "./HomePage.css";
import Navigation from '../Navigation/Navigation';
import MainContent from '../MainContent/MainContent';

class HomePage extends Component{
    constructor(props){

        super(props);
        this.state={}
    }
    render(){
        return(
            <div>
                <Navigation/>
                <MainContent/>
            </div>
        );
    }
}
export default HomePage;