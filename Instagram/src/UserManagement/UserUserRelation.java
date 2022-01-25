package UserManagement;


import java.util.ArrayList;
import java.util.List;

public class UserUserRelation {
    private static List<UserUserRelation > follows = new ArrayList<>();
    private static List<UserUserRelation> blocks = new ArrayList<>();
    private User follower;
    private User following;
    private User blocked;
    private User blocker;
    private boolean isBlockRelation = false;

    public void addToDatabase(){
        follows.add(this);
    }

    public void addToBlocks(){
        follows.add(this);
    }

    public static List<UserUserRelation> getBlocks() {
        return blocks;
    }

    public static void setBlocks(List<UserUserRelation> blocks) {
        UserUserRelation.blocks = blocks;
    }

    public boolean isBlockRelation() { return isBlockRelation; }

    public void setBlockRelation(boolean blockRelation) { isBlockRelation = blockRelation; }

    public User getBlocked() { return blocked; }

    public void setBlocked(User blocked) { this.blocked = blocked; }

    public User getBlocker() { return blocker; }

    public void setBlocker(User blocker) { this.blocker = blocker; }

    public User getFollower() { return follower; }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowing() {
        return following;
    }

    public void setFollowing(User following) {
        this.following = following;
    }

    public static List<UserUserRelation> getFollows() {
        return follows;
    }

    public static void setFollows(List<UserUserRelation> follows) {
        UserUserRelation.follows = follows;
    }
}
