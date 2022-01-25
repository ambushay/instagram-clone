package UserManagment;

import instagram.Poster;
import messaging.Chatroom;

import java.util.ArrayList;
import java.util.List;

public class User extends Poster{
	private static List<User> users = new ArrayList<>();
	private List<Chatroom> chats = new ArrayList<>();
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

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
    
    public List<Chatroom> getChats(){
    	return chats;
    }
    
    public void setChats(List<Chatroom> chtl) {
    	this.chats = chtl;
    }

    public void follow(User user) {
        List<UserUserRelation> userRelationUsers = UserUserRelation.getDatabase();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getFollower() == this && userRelationUser.getFollowing() == user) {
                userRelationUsers.remove(userRelationUser);
                return;
            }
        }

        UserUserRelation userRelationUser = new UserUserRelation();
        userRelationUser.setFollower(this);
        userRelationUser.setFollowing(user);
    }

    public List<User> getFollowers() {
        List<User> followers = new ArrayList<>();
        List<UserUserRelation> userRelationUsers = UserUserRelation.getDatabase();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getFollowing() == this) {
                followers.add(userRelationUser.getFollower());
            }
        }
        return followers;
    }

    public List<User> getFollowing() {
        List<User> following = new ArrayList<>();
        List<UserUserRelation> userRelationUsers = UserUserRelation.getDatabase();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getFollower() == this) {
                following.add(userRelationUser.getFollowing());
            }
        }
        return following;
    }

    public void block(User user) {
        List<UserUserRelation> userRelationUsers = UserUserRelation.getBlockedDatabase();

        for (UserUserRelation userRelationUser : userRelationUsers) {
            if (userRelationUser.getBlocker() == this && userRelationUser.getBlocked() == user) {
                userRelationUsers.remove(userRelationUser);
                return;
            }
        }

        UserUserRelation userRelationUser = new UserUserRelation();
        userRelationUser.setBlocker(this);
        userRelationUser.setBlocked(user);
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

    public static User searchByUsername(String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
