package UserManagement;

import java.awt.image.BufferedImage;

public class Profile {

    private String nickname;
    private String biography;
    private String phoneNumber;
    private String age;
    private String email;
    private BufferedImage bufferedImage;

    public Profile(String mail, String num, String age, String bio) {
    	this.email = mail;
    	this.phoneNumber = num;
    	this.age = age;
    	this.biography = bio;
    }

    public Profile(String nickname) { this.nickname = nickname; }

    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getBiography() { return biography; }

    public void setBiography(String biography) { this.biography = biography; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAge() { return age; }

    public void setAge(String age) { this.age = age; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public BufferedImage getBufferedImage() { return bufferedImage;}

    public void setBufferedImage(BufferedImage bufferedImage) { this.bufferedImage = bufferedImage; }
}
