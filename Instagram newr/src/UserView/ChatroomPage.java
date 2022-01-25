package UserView;

import java.util.List;
import java.util.Scanner;

import Messaging.Chatroom;
import Messaging.Message;
import UserManagement.User;


public class ChatroomPage {
    private Chatroom chatroom;
    private static Scanner scanner = new Scanner(System.in);
    private User user;

    public ChatroomPage(Chatroom chat, User usr) {
        chatroom = chat;
        user = usr;
    }

    private void showMenu() {
        System.out.println("1. send message");
        System.out.println("2. Exit");
    }

    public void run() {
        while (true) {
            showMessages();
            showMenu();
            System.out.println("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                return;
            }
            if (choice == 1) {
                sendMessage();
            }
        }
    }

    private void showMessages() {
        List<Message> messages = chatroom.getMessages();
        if(messages.isEmpty()){
            System.out.println("Empty!");
            return;
        }
        for (Message message : messages) {
            System.out.println(message.showMessage());
        }
    }


    private void sendMessage() {
        List<Message> msgs = chatroom.getMessages();
        System.out.println("Enter your text message: ");
        String newtxt = scanner.nextLine();
        Message newmsg = new Message (user, newtxt);
        msgs.add(newmsg);
        chatroom.setMessages(msgs);
    }



}