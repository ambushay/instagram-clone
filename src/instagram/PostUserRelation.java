package instagram;

public class PostUserRelation {
	private Poster poster;
    private boolean isLiked = false;
    private boolean isFavorite = false;


    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public Poster getPostUser() {
        return poster;
    }

    public void setPostUser(Poster poster) {
        this.poster = poster;
    }
}
