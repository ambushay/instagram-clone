package PostManagement;

import UserManagement.User;

public class PostUserRelation {
    private UserManagement.User user;
    private boolean isLiked = false;
    private boolean isCommented = false;
    private String comment;

    public PostUserRelation() {
    }

    public PostUserRelation(User user, boolean isLiked) {
        this.user = user;
        this.isLiked = isLiked;
    }

    public PostUserRelation(User user, boolean isLiked, String comment) {
        this.user = user;
        this.isLiked = isLiked;
        this.comment = comment;
    }

    public boolean isCommented() { return isCommented; }

    public void setCommented(boolean commented) { isCommented = commented; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) { isLiked = liked; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}
