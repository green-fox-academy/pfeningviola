package com.greenfoxacademy.redditproject.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  private String name;
  private String password;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "user_id")
  private List<Post> posts;
  private ArrayList<VotedPost> votedPosts;

  public User(){
    this.votedPosts = new ArrayList<>();
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public ArrayList<VotedPost> getVotedPosts() {
    return votedPosts;
  }

  public void setVotedPosts(ArrayList<VotedPost> votedPosts) {
    this.votedPosts = votedPosts;
  }
}
