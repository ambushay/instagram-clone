package instagram;

import UserManagment.User;

import java.util.ArrayList;
import java.util.List;


public class Post {
	private String text; //TODO files
    private List<Post> posts = new ArrayList<>();
    private List<PostUserRelation> postUserRelations = new ArrayList<>();
    private PostType postType;

    public Post(String text) { //TODO files
        if (text.length() > 140) {
            throw new IllegalArgumentException();
        }
        this.text = text;
    }


    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public String getText() { //TODO files
        return text;
    }

    public void setText(String text) { //TODO files
        this.text = text;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<PostUserRelation> getPostUserRelations() {
        return postUserRelations;
    }

    public void setPostUserRelations(List<PostUserRelation> postUserRelations) {
        this.postUserRelations = postUserRelations;
    }

    public static List<Post> searchByKeyword(String keyword){
        List<User> users = User.getUsers();
        List<Post> foundPosts = new ArrayList<>();
        for(User user : users){
            for(Post tweet: user.getPosts()){
                if(tweet.getText().contains(keyword)){
                    foundPosts.add(tweet);
                }
            }
        }
        return foundPosts;
    }

    public List<Post> getComments(){
        List<Post> comments = new ArrayList<>();
        for(Post post: posts){
            if(post.getPostType() == PostType.Comment){
                comments.add(post);
            }
        }
        return comments;
    }
    
/*
    public List<Post> getReTweet(){
        List<Post> reTweet = new ArrayList<>();
        for(Post tweet: posts){
            if(tweet.getTweetType() == PostType.ReTweet){
                reTweet.add(tweet);
            }
        }
        return reTweet;
    }*/
}
