import React, {Component} from 'react';
import "./MainContent.css";
import Grid  from '@mui/material/Grid';
import PostPage from '../PostPage/PostPage.js';

class MainContent extends Component{
    constructor(props){

        super(props);
        this.state={}
    }
    render(){
        return(
            <div>
                <Grid container>
                    <Grid item xs={2}></Grid>
                    <Grid item xs={6}>
                        <div>
                            <PostPage/>
                        </div>
                    </Grid>
                    <Grid item xs={2}>c</Grid>
                    <Grid item xs={2}>d</Grid>
                </Grid>
            </div>
        );
    }
}
export default MainContent;