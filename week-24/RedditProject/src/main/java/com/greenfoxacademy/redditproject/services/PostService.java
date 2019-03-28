package com.greenfoxacademy.redditproject.services;

import com.greenfoxacademy.redditproject.models.Post;
import com.greenfoxacademy.redditproject.models.User;
import com.greenfoxacademy.redditproject.models.VotedPost;
import com.greenfoxacademy.redditproject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostService {
  private PostRepository postRepository;
  private UserService userService;

  @Autowired
  public PostService(PostRepository postRepository, UserService userService){
    this.postRepository = postRepository;
    this.userService = userService;
  }

  public ArrayList<Post> findAllPost(){
    ArrayList<Post> posts = new ArrayList<>();
    postRepository.findAll().forEach(posts::add);
    return posts;
  }

  public ArrayList<Post> findAllPostByScoreOrderDesc(){
    return postRepository.findAllByOrderByScoreDesc();
  }

  public void save(Post post){
    postRepository.save(post);
  }

  public void delete(Long id) {
    postRepository.delete(findPostById(id));
  }

  public void upvotePost(Long votingUserId, Long id){
    Post post = findPostById(id);
    post.setScore(post.getScore() + 1);
    postRepository.save(post);

    if (checkIfPostVotedByGivenUser(votingUserId, id)){
      userService.removeVotedPost(votingUserId, id);
    } else {
      userService.addVotedPost(votingUserId, post, true);
    }
  }

  public void downvotePost(Long votingUserId, Long id){
    Post post = findPostById(id);
    post.setScore(post.getScore() - 1);
    postRepository.save(post);

    if (checkIfPostVotedByGivenUser(votingUserId, id)){
      userService.removeVotedPost(votingUserId, id);
    } else {
      userService.addVotedPost(votingUserId, post, false);
    }
  }

  public Post findPostById(Long id){
    Optional<Post> postOptional = postRepository.findById(id);
    Post post = new Post();
    if(postOptional.isPresent()) {
      post = postOptional.get();    }
    return post;
  }

  public boolean checkIfUsersPost(Long userId, Long id){
    User user = userService.findUserById(userId);
    Post post = findPostById(id);
    return user.getPosts().contains(post);
  }

  public boolean checkIfAlreadyVoted(Long userId, Long id, boolean upvoted, boolean downvoted) {
    User user = userService.findUserById(userId);
    ArrayList<VotedPost> votedPosts = user.getVotedPosts();
    if(!votedPosts.isEmpty()) {
      for (VotedPost votedPost : votedPosts) {
        if (votedPost.getId().equals(id)) {
          if((votedPost.isUpvoted() == upvoted) || (votedPost.isDownvoted() == downvoted)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean checkIfPostVotedByGivenUser(Long userId, Long id){
    User user = userService.findUserById(userId);
    ArrayList<VotedPost> votedPosts = user.getVotedPosts();
    if(!votedPosts.isEmpty()) {
      for (VotedPost votedPost : votedPosts) {
        if (votedPost.getId().equals(id)) {
          return true;
        }
      }
    }
    return false;
  }
}
