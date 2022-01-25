package UserView;

import instagram.Post;
import instagram.PostType;
import instagram.PostUserRelation;
import UserManagment.User;

import java.io.IOException;
import java.util.Scanner;

public class PostPage {
    private Post post;
    private User user;
    private static Scanner scanner = new Scanner(System.in);

    public PostPage(Post post, User user) {
        this.post = post;
        this.user = user;
    }

    private void showMenu() {
        System.out.println("1. Like post");
        System.out.println("2. Comment on post");
        System.out.println("3. Favorite post"); //TODO remove?
        System.out.println("4. Re post"); //TODO remove?
        System.out.println("5. Exit");
    }

    public void run() {
        while (true) {
            showPost();
            showMenu();
            System.out.println("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 5) {
                return;
            }
            if (choice == 1) {
                user.likePost(post);
            } else if (choice == 2) {
                commentPost();
            } else if (choice == 3) {
                favoritePost();
            } else if (choice == 4) {
                rePost();
            }
        }
    }

    private void showPost() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException ignore) {
        }
        System.out.println(post.getText());
        boolean liked = false;
        boolean favorite = false;
        for (PostUserRelation postUserRelation : post.getPostUserRelations()) {
            if (postUserRelation.getPostUser() == user) {
                liked = postUserRelation.isLiked();
                favorite = postUserRelation.isFavorite();
                break;
            }
        }
        System.out.println("Liked: " + liked);
        System.out.println("Favorite: " + favorite);
        showComments();

    }

    private void commentPost() {
        String text = scanner.nextLine();
        Post commentPost = new Post(text);
        commentPost.setPostType(PostType.Comment);
        user.makePost(commentPost, post);
    }

    private void rePost() {
        Post myPost = new Post(post.getText());
        myPost.setPostType(PostType.RePost);
        user.makePost(myPost, post);
    }

    private void favoritePost() {
        user.favoritePost(post);
    }

    private void showComments() {
        for (Post p : post.getComments()) {
            System.out.println(p.getText());
        }
    }
}
