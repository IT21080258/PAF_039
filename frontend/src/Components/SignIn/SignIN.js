import React, { Component } from 'react';
import '../LoginPage/LoginPage.css';

class SignIN extends Component {

    constructor(props){

        super(props);
        this.state={}
    }

    render(){

        return(

            <div>
                <input className='loginpage_text' type="text" placeholder='Phone number , username , or email' />
                <input className='loginpage_text' type="password" placeholder='password' />
                <button className='login_button'>Log In</button>
            </div>

        );
    }
}

export default SignIN;