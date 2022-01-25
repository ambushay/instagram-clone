package PostManagement;

import UserManagement.User;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Post {
    private String caption;
    private File mediaFile;     //photo , video , gif
    private List<PostUserRelation> postUserRelations = new ArrayList<>();//likes and comments
    private int likesCount=0;

    public Post() { }

    public Post(String caption) { this.caption = caption; }

    public Post(String caption, File mediaFile) {
        this.caption = caption;
        this.mediaFile = mediaFile;
    }

    public void incLikes(){likesCount++;}

    public void decLikes(){likesCount--;}

    public int getLikesCount() { return likesCount; }

    public void setLikesCount(int likesCount) { this.likesCount = likesCount; }

    public String getCaption() { return caption; }

    public void setCaption(String caption) { this.caption = caption; }

    public File getMediaFile() { return mediaFile; }

    public void setMediaFile(File mediaFile) { this.mediaFile = mediaFile; }

    public List<PostUserRelation> getPostUserRelations() {
        return postUserRelations;
    }

    public void setPostUserRelations(List<PostUserRelation> postUserRelations) { this.postUserRelations = postUserRelations; }

    public static List<Post> searchByKeyword(String keyword){
        List<User> users = User.getUsers();
        List<Post> foundPosts = new ArrayList<>();
        for(User user : users){
            for(Post tweet: user.getPosts()){
                if(tweet.getCaption().contains(keyword)){
                    foundPosts.add(tweet);
                }
            }
        }
        return foundPosts;
    }

    public List<PostUserRelation> getComments(){    //return the users who have commented on this post and their comment
        List<PostUserRelation> comments = new ArrayList<>();
        for(PostUserRelation postUserRelation: postUserRelations){
            if(postUserRelation.isCommented()){
                comments.add(postUserRelation);
            }
        }
        return comments;
    }

    public List<User> getLikes(){   //return the users who have liked this post
        List<User> likes = new ArrayList<>();
        for(PostUserRelation postUserRelation: postUserRelations){
            if(postUserRelation.isLiked()){
                likes.add(postUserRelation.getUser());
            }
        }
        return likes;
    }

    @Override
    public String toString() {
        return "Post{" +
                "caption='" + caption + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }
}
