package Messaging;

import java.util.ArrayList;
import java.util.List;

import UserManagement.User;

public class Chatroom {
    private static List<Chatroom> allchatrooms = new ArrayList<>();
    private User user1;
    private User user2;
    private List<Message> messages = new ArrayList<>();
    private String name;

    public Chatroom(User sender, User receiver) {
        user1 = sender;
        user2 = receiver;
        name = user1.getUsername() + " and " + user2.getUsername() + " chatroom";
        user1.getChats().add(this);
        user2.getChats().add(this);
    }

    public void setSender(User s) {
        this.user1 = s;
    }

    public User getSender() {
        return this.user1;
    }

    public void setReceiver(User s) {
        this.user2 = s;
    }

    public User getReceiver() {
        return this.user2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setMessages(List<Message> msgl) {
        this.messages = msgl;
    }

    public List<Message> getMessages(){
        return this.messages;
    }

    public static void setAllchats(List<Chatroom> chts) {
        Chatroom.allchatrooms = chts;
    }

    public static List<Chatroom> getAllchats(){
        return Chatroom.allchatrooms;
    }

}