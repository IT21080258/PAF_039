import React, { Component } from 'react';
import './SignUp.css';

class SignUp extends Component {

    constructor(props){

        super(props);
        this.state={}
    }

    render(){

        return(

            <div>

                <input className='loginpage_text' type="text" placeholder='Mobile Number or Email' />
                <input className='loginpage_text' type="text" placeholder='Full Name' />
                <input className='loginpage_text' type="text" placeholder='UserName' />
                <input className='loginpage_text' type="password" placeholder='password' />
                <button className='login_button'>Sign up</button>

            </div>

        );
    }
}

export default SignUp;