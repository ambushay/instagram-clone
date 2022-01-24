package instagram;

import UserManagment.UserUserRelation;

import java.util.ArrayList;
import java.util.List;

public abstract class Poster {
    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void makePost(Post post) throws IllegalArgumentException {
        if (post.getPostType() != PostType.Content) {
            throw new IllegalArgumentException();
        }
        posts.add(post);
    }

    public void makePost(Post post, Post relatedPost) {
        if (post.getPostType() == PostType.Content) {
            throw new IllegalArgumentException();
        }

        relatedPost.getPosts().add(post);
        posts.add(post);
    }

    public void likePost(Post post) {
        List<PostUserRelation> postUserRelations = post.getPostUserRelations();
        for (PostUserRelation postUserRelation : postUserRelations) {
            if(postUserRelation.getPostUser() == this){
                boolean liked = postUserRelation.isLiked();
                postUserRelation.setLiked(!liked);
                return;
            }
        }
        PostUserRelation postUserRelation = new PostUserRelation();
        postUserRelation.setLiked(true);
        postUserRelation.setFavorite(false);
        postUserRelation.setPostUser(this);
        post.getPostUserRelations().add(postUserRelation);
    }
    public void favoritePost(Post post){
        List<PostUserRelation> postUserRelations = post.getPostUserRelations();
        for (PostUserRelation postUserRelation : postUserRelations) {
            if(postUserRelation.getPostUser() == this){
                boolean favorite = postUserRelation.isFavorite();
                postUserRelation.setFavorite(!favorite);
                return;
            }
        }
        PostUserRelation postUserRelation = new PostUserRelation();
        postUserRelation.setLiked(false);
        postUserRelation.setFavorite(true);
        postUserRelation.setPostUser(this);
        post.getPostUserRelations().add(postUserRelation);
    }
}
