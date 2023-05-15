import React, {Component} from 'react';
import "./Navigation.css";
import Grid from '@mui/material/Grid'
import foodie_logo from '../../images/logofoodie.png'
import Avatar from '@mui/material/Avatar';
import profile from '../../images/pp2.png'

class Navigation extends Component{
    constructor(props){

        super(props);
        this.state={}
    }
    render(){
        return(
            <div>
                <div className='Navigation_Content'>
                    <Grid container>
                        <Grid xs={2}>
                            
                        </Grid>
                        <Grid xs={3}>
                            <img className='Navigation_logo' src = {foodie_logo} width="100px"/>
                        </Grid>
                        <Grid xs={4}>
                            <input className='Navigation_search' text="text" placeholder='Search'/>
                        </Grid>
                        <Grid xs={3}>
                            <Avatar className='Navigation_profilepic' src={profile}/>
                        </Grid>
                    </Grid>
                </div>
            </div>
        );
    }
}
export default Navigation;