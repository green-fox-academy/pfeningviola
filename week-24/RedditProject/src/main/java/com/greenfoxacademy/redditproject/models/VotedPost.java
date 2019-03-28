package com.greenfoxacademy.redditproject.models;


import java.io.Serializable;

public class VotedPost implements Serializable {
  private Long id;
  private Post post;
  private boolean upvoted;
  private boolean downvoted;

  public VotedPost(Post post, boolean upvoted){
    this.post = post;
    this.id = post.getId();
    this.upvoted = upvoted;
    if (upvoted){
      this.downvoted = false;
    } else {
      this.downvoted = true;
    }
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public boolean isUpvoted() {
    return upvoted;
  }

  public void setUpvoted(boolean upvoted) {
    this.upvoted = upvoted;
  }

  public boolean isDownvoted() {
    return downvoted;
  }

  public void setDownvoted(boolean downvoted) {
    this.downvoted = downvoted;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
