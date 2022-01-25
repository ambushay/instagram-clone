package PostManagement;

import java.util.ArrayList;
import java.util.List;

public class Poster {
    private List<Post> posts = new ArrayList<>();   //postaye yek nafar(user)

    public Poster() {
    }

    public Poster(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void makePost(Post post){
        posts.add(post);
    }

}
