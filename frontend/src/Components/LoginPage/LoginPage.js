import React, { Component } from 'react';
import './LoginPage.css';
import Grid from '@mui/material/Grid';
import inst_image from '../../images/MainPagePhone.png';
import insta_logo from '../../images/logofoodie.png';
import fb from '../../images/fb.png';
import appstore from '../../images/app.png';
import playstore from '../../images/play.png';
import SignIN from '../SignIn/SignIN';
import SignUp from '../SignUp/SignUp';


class LoginPage extends Component{

    constructor(props){

        super(props);
        this.state = {

            isLogin : true
        }
    }

    changeLogin=()=>{

        if(this.state.isLogin)
            this.setState({isLogin:false});
        
        else
        this.setState({isLogin:true});
    }
    render() {

        return(

                <div>
                    <Grid container>

                        {/*Left Component*/ }
                        <Grid item xs={3}>
                            
                        </Grid>

                        {/*Middle Component*/ }
                    <Grid item xs={6}>


                        <div className='loginpage_main'>

                            {/*For iamge of the Mobile*/}
                            <div>
                                <img src={inst_image} width="320px" height="600px" />
                            </div>

                            {/*For Login */}
                            <div>

                                <div className='loginpage_rightcomponent'>
                                    <img className='loginpage_logo' src={insta_logo} />

                                    <div className='loginpage_signin'>
                                        
                                        {

                                            this.state.isLogin ? <SignIN/> :<SignUp/>
                                        }
                                        {/* <SignIN/> */}
                                        {/* <SignUp/> */}

                                        <div className='login_ordiv'>
                                            <div className='login_devider'></div>
                                            <div className='login_or'>OR</div>
                                            <div className='login_devider'></div>
                                            
                                        </div>

                                        <div className='login_fb'>
                                        <img src={fb} width='15pxs' style={{" marginRight":"5px"}}/>Log in with Facebook
                                        </div>
                                            
                                        
                                        <div className='login_forgot'>Forgot password</div>

                                    </div>
                                </div>

                                    <div className='loginpage_signupoption'>

                                            {

                                                      this.state.isLogin ? <div className='loginpage_signup'>
                                                        Don't have an account?<span onClick={this.changeLogin} style={{"fontWeight":"bold", "color":"#0395F6"}} >Sign up</span></div> 
                                                        :<div className='loginpage_signin'>
                                                        Have an account ? <span  onClick={this.changeLogin} style={{"fontWeight":"bold", "color":"#0395F6"}} >Sign in</span>
                                                    </div>
                                            }

                                            
                                            

                                            <div className='loginPage_downloadSection'>
                                                <div >
                                                    Get the app.
                                                </div>
                                                <div className='loginpage_option'>
                                                    <img className='loginPage_dwing' src={appstore} width="136px"/>
                                                    <img className='loginPage_dwing' src={playstore} width="136px"/>
                                                </div>

                                            </div>

                                    </div>

                            </div>

                        </div>
                    </Grid>

                        {/*Right Component*/ }
                        <Grid item xs={3}>
                           
                        </Grid>
                    </Grid>
                </div>

        );
    }


}

export default LoginPage;