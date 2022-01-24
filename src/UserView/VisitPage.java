package UserView;

import instagram.Post;
import instagram.PostType;
import instagram.PostUserRelation;
import UserManagment.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitPage {/*
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
        System.out.println("3. block/ unblock");
        System.out.println("4. log out");
    }
	
    public void run() {
        while (true) {
            showMenu();
            System.out.println("choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 4) {
                return;
            }
            if (choice == 1) {
            	showTheirPosts();
            } else if (choice == 2) {
                
            } else if (choice == 3) {
                
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
    
    private void showTheirPosts() {
        List<Post> posts = visited.getPosts();
        showPosts(posts);
    }
    
    public void followUnfollow(User visited) {
        List<PostUserRelation> postUserRelations = visited.getPostUserRelations();
        for (PostUserRelation postUserRelation : postUserRelations) {
            if(postUserRelation.getPostUser() == this){
                boolean liked = postUserRelation.isLiked();
                postUserRelation.setLiked(!liked);
                return;
            }
        }
        PostUserRelation postUserRelation = new PostUserRelation();
        postUserRelation.setLiked(true);
        postUserRelation.setFavorite(false);
        postUserRelation.setPostUser(this);
        visited.getPostUserRelations().add(postUserRelation);
    }
	*/
}
