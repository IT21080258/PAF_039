import React, {Component} from 'react';
import "./PostPage.css";
import Post from '../Post/Post.js'

class PostPage extends Component{
    constructor(props){

        super(props);
        this.state={}
    }
    render(){
        return(
            <div>
                <Post/>
            </div>
        );
    }
}
export default PostPage;