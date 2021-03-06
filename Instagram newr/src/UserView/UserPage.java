package UserView;

import Messaging.Chatroom;
import PostManagement.Post;
import UserManagement.User;

import java.io.File;
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
        System.out.println("3. Show all my followings posts");
        System.out.println("4. Search post by keyword");
        System.out.println("5. show my chatrooms");
        System.out.println("6. show my followers");
        System.out.println("7. show All Users of the system");
        System.out.println("8. log out");
    }

    private Post makePost() {
        System.out.println("Enter Caption");
        String text = scanner.nextLine();
        System.out.println("Enter mediaFile directory:");
        String dir = scanner.nextLine();
        Post post = new Post(text, new File(dir));
        user.makePost(post);
        return post;
    }

    public void run() {
        while (true) {
            showMenu();
            System.out.println("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 8) {
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
            } else if ( choice == 5){
                showRooms();
            } else if (choice == 6){
                showFollowers();
            }else if (choice == 7){
                showAllUsers();
            }
        }
    }



    private void showFollowers() {
        List<User> followers = user.getFollowers();
        if(followers.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        int i = 0;
        for (User follower : followers) {
            System.out.println((i + 1) + ". " + follower.getUsername());
            ++i;
        }
        System.out.println("Choose a follower by number (-1 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == -1) {
            return;
        }
        --choice;
        if(choice >= followers.size()){
            System.out.println("Invalid option");
            return;
        }
        User visited = followers.get(choice);
        VisitPage visitPage = new VisitPage(user, visited);
        visitPage.run();
    }

    private void showRooms() {
        List<Chatroom> chatrooms = user.getChats();
        if(chatrooms.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        int i = 0;
        for (Chatroom chat : chatrooms) {
            System.out.println((i + 1) + ". " + chat.getName());
            ++i;
        }
        System.out.println("Choose a chat by number (-1 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == -1) {
            return;
        }
        --choice;
        if(choice >= chatrooms.size()){
            System.out.println("Invalid option");
            return;
        }
        Chatroom chatroom = chatrooms.get(choice);
        ChatroomPage chatPage = new ChatroomPage(chatroom, user);
        chatPage.run();
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
            System.out.println((i + 1) + ". " + post);
            ++i;
        }
        System.out.println("Choose a post by number (-1 to exit): ");
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

    public void showAllUsers(){
        List<User> users = User.getUsers();
        if(users.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        int i = 0;
        for (User user : users) {
            System.out.println((i + 1) + ". " + user);
            ++i;
        }
        System.out.println("Choose a User by number (-1 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == -1) {
            return;
        }
        --choice;
        if(choice >= users.size()){
            System.out.println("Invalid option");
            return;
        }
        User newUser = users.get(choice);
        VisitPage visitPage = new VisitPage(user, newUser);
        visitPage.run();
    }
}
