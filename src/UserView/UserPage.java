package UserView;

import instagram.Post;
import instagram.PostType;
import UserManagment.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPage {
	private static Scanner scanner = new Scanner(System.in);
    private User user;

    public UserPage(User user) {
        this.user = user;
    }

    private void showMenu() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException ignored) {

        }
        System.out.println("1. Make post.");
        System.out.println("2. Show my posts");
        System.out.println("3. Show all posts");
        System.out.println("4. Search post by keyword");
        System.out.println("5. log out");
    }

    private Post makePost() {
        String text = scanner.nextLine();
        Post post = new Post(text);
        post.setPostType(PostType.Content);
        user.makePost(post);
        return post;
    }

    public void run() {
        while (true) {
            showMenu();
            System.out.println("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 5) {
                return;
            }
            if (choice == 1) {
                makePost();
            } else if (choice == 2) {
                showMyPosts();
            } else if (choice == 3) {
                showAllPosts();
            } else if (choice == 4) {
                searchByKeyword();
            }
        }
    }

    private void showMyPosts() {
        List<Post> posts = user.getPosts();
        showPosts(posts);
    }

    private void showAllPosts() {
        List<User> users = user.getFollowers();
        List<Post> posts = new ArrayList<>();
        for (User user : users) {
            posts.addAll(user.getPosts());
        }
        showPosts(posts);
    }

    private void searchByKeyword() {
        System.out.println("Enter the keyword: ");
        String keyword = scanner.nextLine();
        List<Post> posts = Post.searchByKeyword(keyword);
        showPosts(posts);
    }

    private void showPosts(List<Post> posts) {
        if(posts.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        int i = 0;
        for (Post post : posts) {
            System.out.println((i + 1) + ". " + post.getText());
            ++i;
        }
        System.out.println("Choose a tweet by number (-1 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == -1) {
            return;
        }
        --choice;
        if(choice >= posts.size()){
            System.out.println("Invalid option");
            return;
        }
        Post post = posts.get(choice);
        PostPage postPage = new PostPage(post, user);
        postPage.run();
    }
}
