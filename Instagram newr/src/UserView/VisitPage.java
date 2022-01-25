package UserView;

import Messaging.Chatroom;
import PostManagement.Post;
import UserManagement.User;
import UserManagement.UserUserRelation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class VisitPage {
    private static Scanner scanner = new Scanner(System.in);
    private User user;
    private User visited;

    public VisitPage (User visiter, User visitee) {
        this.user = visiter;
        this.visited = visitee;
    }

    private void showMenu() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException ignored) {

        }
        System.out.println("1. Show their posts");
        System.out.println("2. follow/ unfollow");
        System.out.println("3. block");
        System.out.println("4. chat");
        System.out.println("5. log out");
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
                showTheirPosts();
            } else if (choice == 2) {
                followUnfollow();
            } else if (choice == 3) {
                block();
            } else if (choice == 4) {
                startChat();
            }
        }
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
        System.out.println("Choose a Post by number (-1 to exit): ");
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

    private void showTheirPosts() {
        //UserUserRelation.getBlockedDatabase();
        if(visited.isblocked(user)) {
            return;
        }
        List<Post> posts = visited.getPosts();
        showPosts(posts);
    }

    private void followUnfollow() {
        user.follow(visited);
    }

    private void block() {
        user.block(visited);
    }

    private void startChat() {
        List<Chatroom> chats = Chatroom.getAllchats();
        for (Chatroom chat : chats) {
            if((chat.getSender() == user && chat.getReceiver() == visited) || (chat.getSender() == visited && chat.getReceiver() == user)) {
                ChatroomPage chatroomPage = new ChatroomPage (chat, user);
                chatroomPage.run();
                return;
            }
        }
        Chatroom newChatroom = new Chatroom(user, visited);
        chats.add(newChatroom);
        Chatroom.setAllchats(chats);
        ChatroomPage chatroomPage = new ChatroomPage (newChatroom, user);
        chatroomPage.run();
    }


}