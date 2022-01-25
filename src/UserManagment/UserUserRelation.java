package UserManagment;

import instagram.Post;

import java.util.ArrayList;
import java.util.List;

public class UserUserRelation {
	private static List<UserUserRelation> database = new ArrayList<>();
	private static List<UserUserRelation> blockeddatabase = new ArrayList<>();
    private User follower;
    private User following;
    private User blocker;
    private User blocked;

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
    
    public User getBlocker() {
        return blocker;
    }

    public void setBlocker(User blocker) {
        this.blocker = blocker;
    }

    public User getBlocked() {
        return blocked;
    }

    public void setBlocked(User blocked) {
        this.blocked = blocked;
    }

    public static List<UserUserRelation> getBlockedDatabase() {
        return blockeddatabase;
    }

    public static void setBlockedDatabase(List<UserUserRelation> blockeddatabase) {
        UserUserRelation.blockeddatabase = blockeddatabase;
    }

}
