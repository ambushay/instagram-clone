package UserView;

import PostManagement.Post;
import UserManagement.User;
import PostManagement.PostUserRelation;


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
        System.out.println("3. Exit");
    }

    public void run() {
        while (true) {
            showPost();
            showMenu();
            System.out.println("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 3) {
                return;
            }
            if (choice == 1) {
                user.likePost(post);
            } else if (choice == 2) {
                commentPost();
            }
        }
    }

    private void showPost() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException ignore) {
        }
        System.out.println(post);
        showComments();

    }

    private void commentPost() {
        System.out.println("Enter Comment:");
        String comment = scanner.nextLine();
        user.comment(post,comment);
    }


    private void showComments() {
        for (PostUserRelation p : post.getComments()) {
            System.out.println(p.getUser() + " : "+ p.getComment());
        }
    }
}
