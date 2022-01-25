package messaging;

import UserManagment.User;

public class Message {
	private User sender;
	private String text;
	
	public Message(User u, String str) {
		sender = u;
		text = str;
	}
	
	public void setSender(User s) {
		this.sender = s;
	}
	
	public User getSender() {
		return this.sender;
	}
	
	public void setText(String txt) {
		this.text = txt;
	}
	
	public String getText() {
		return this.text;
	}
	
	public String showMessage() {
		return this.sender.getUsername() + ": " + this.text;
	}
}

