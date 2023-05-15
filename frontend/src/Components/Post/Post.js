import React, {Component} from 'react';
import "./Post.css";
import { Avatar } from '@mui/material';
import postimage from '../../images/post.jpg'
import like from '../../images/love.svg'
import comment from '../../images/comment.svg'

class Post extends Component{
    constructor(props){

        super(props);
        this.state={}
    }
    render(){
        return(
            <div className='Post_container'>
                {/* User */}
                <div className='Post_header'>
                    <Avatar className='Post_profilepic'/>
                    <div className='Post_username'>User Name</div>
                </div>
                {/* Restuarant name */}
                <div></div>
                {/* Image */}
                <div className='post_images'> 
                    <img src={postimage}/>
                </div>
                {/* Likes */}
                <div>
                    <div style={{"marginLeft":"10px"}}>
                        <img src={like} className='Post_reactimage'/>
                        <img src={comment} className='Post_reactimage'/>
                    </div>
                    <div style={{ "fontWeight":"bold","marginLeft":"20px  "}}>
                        34 likes     
                    </div>
                </div>
                {/* Comment */}
                <div>
                    <div className='Post_comment'>Comment</div>
                    <div className='Post_comment'>Comment</div>
                    <div className='Post_comment'>Comment</div>
                    <input className='Post_commenttextbox' type='text' placeholder='Add a comment...'/>
                </div>
            </div>
        );
    }
}
export default Post;