import PostManagement.Post;
import UserView.RegisterPage;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        RegisterPage registerPage = new RegisterPage();
        registerPage.run();
        Post post = new Post();
        post.setCaption("dfd");
        post.setMediaFile(new File("dfdd"));


    }

}
