package UserManagment;

import instagram.Post;

import java.util.ArrayList;
import java.util.List;

public class UserUserRelation {
	private static List<UserUserRelation> database = new ArrayList<>();
    private User follower;
    private User following;

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }

    public static List<UserUserRelation> getDatabase() {
        return database;
    }

    public static void setDatabase(List<UserUserRelation> database) {
        UserUserRelation.database = database;
    }

}
