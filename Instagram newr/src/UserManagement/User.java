package UserManagement;

import Messaging.Chatroom;
import PostManagement.Post;
import PostManagement.PostUserRelation;
import PostManagement.Poster;

import java.util.ArrayList;
import java.util.List;


public class User extends Poster{
    private static List<User> users = new ArrayList<>();
    private List<Chatroom> chats = new ArrayList<>();
    private String username;
    private String password;
    private Profile profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void follow(User user) {
        //check to see if the user we want to follow, has not blocked us
        List<UserUserRelation> blocks = UserUserRelation.getBlocks();
        for(UserUserRelation blockRelation:blocks){
            if(blockRelation.getBlocker() == user && blockRelation.getBlocked() == this && blockRelation.isBlockRelation() ){
                System.out.println("Can not follow.(Blocked)");
                return;
            }
            if(blockRelation.getBlocker() == this && blockRelation.getBlocked() == user && blockRelation.isBlockRelation()){
                System.out.println("Can not follow! The user is blocked by you!");
                return;
            }
        }

        //unfollow
        List<UserUserRelation> userRelationUsers = UserUserRelation.getFollows();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getFollower() == this && userRelationUser.getFollowing() == user) {
                userRelationUsers.remove(userRelationUser);     //unfollow
                return;
            }
        }
        //follow
        UserUserRelation userUserRelation = new UserUserRelation();
        userUserRelation.setFollower(this);
        userUserRelation.setFollowing(user);
        userUserRelation.addToDatabase();
    }


    public void block(User user){
        List<UserUserRelation> userUsersRelation = UserUserRelation.getFollows();
        for(UserUserRelation relation:userUsersRelation){
            if(relation.getFollower() == this && relation.getFollowing() == user){
                userUsersRelation.remove(relation);
            }
            if(relation.getFollower() == user && relation.getFollowing() == this){
                userUsersRelation.remove(relation);
            }
            UserUserRelation blockRelation = new UserUserRelation();
            blockRelation.setBlocked(user);
            blockRelation.setBlocker(this);
            blockRelation.setBlockRelation(true);
            blockRelation.addToBlocks();
        }
    }

    public List<User> getFollowers() {
        List<User> followers = new ArrayList<>();
        List<UserUserRelation> userRelationUsers = UserUserRelation.getFollows();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getFollowing() == this && !userRelationUser.isBlockRelation()) {
                followers.add(userRelationUser.getFollower());
            }
        }
        return followers;
    }

    public List<User> getFollowing() {
        List<User> following = new ArrayList<>();
        List<UserUserRelation> userRelationUsers = UserUserRelation.getFollows();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getFollower() == this && !userRelationUser.isBlockRelation()) {
                following.add(userRelationUser.getFollowing());
            }
        }
        return following;
    }

    public static User signUp(String username, String password){
        for (User user : users){
            if(user.getUsername().equals(username)){
                return null;
            }
        }
        User user = new User(username, password);
        users.add(user);
        return user;
    }

    public static User login(String username, String password){
        for(User user: users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }


    public void likePost(Post post) {
        //if the relation does not exist
        List<PostUserRelation> postUserRelations = post.getPostUserRelations();
        for (PostUserRelation postUserRelation : postUserRelations) {
            if(postUserRelation.getUser() == this){
                boolean liked = postUserRelation.isLiked();
                if(liked == true){post.decLikes();}
                postUserRelation.setLiked(!liked);
                return;
            }
        }
        //if the relation exists
        PostUserRelation postUserRelation = new PostUserRelation();
        postUserRelation.setLiked(true);
        postUserRelation.setUser(this);
        post.getPostUserRelations().add(postUserRelation);
        post.incLikes();
    }

    public void comment(Post post,String comment){
        PostUserRelation postUserRelation = new PostUserRelation();
        postUserRelation.setUser(this);
        postUserRelation.setComment(comment);
        post.getPostUserRelations().add(postUserRelation);
    }

    public static User searchByUsername(String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        User.users = users;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Chatroom> getChats() {
        return chats;
    }

    public void setChats(List<Chatroom> chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public boolean isblocked(User user ){
        List<UserUserRelation> blocks = UserUserRelation.getBlocks();
        for(UserUserRelation relation:blocks){
            if(relation.getBlocker() == this && relation.getBlocked()==user && relation.isBlockRelation()){
                return true;
            }
        }
        return false;
    }
}
