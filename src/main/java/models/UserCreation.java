package models;

import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserCreation {
    private String nickname;
    private String user;
    private String password;
    private Date createdAt = new Date(System.currentTimeMillis());
    private String bio = "";
    private ArrayList<Integer> followers = new ArrayList<Integer>();
    private ArrayList<Integer> following = new ArrayList<Integer>();

    public void setFollower(Integer id) {
        this.followers.add(id);
    }

    public ArrayList<Integer> getFollowers() {
        return followers;
    }

    public void setFollowing(Integer id) {
        this.following.add(id);
    }

    public ArrayList<Integer> getFollowing() {
        return following;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUser() {
        return user;
    }

    // @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFollowers(ArrayList<Integer> followers) {
        this.followers = followers;
    }

    public void setFollowing(ArrayList<Integer> following) {
        this.following = following;
    }
}
