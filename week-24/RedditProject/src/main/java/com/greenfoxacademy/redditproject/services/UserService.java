package com.greenfoxacademy.redditproject.services;

import com.greenfoxacademy.redditproject.models.Post;
import com.greenfoxacademy.redditproject.models.User;
import com.greenfoxacademy.redditproject.models.VotedPost;
import com.greenfoxacademy.redditproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public void save(User user){
    userRepository.save(user);
  }

  public User findUserById(Long userId) {
    Optional<User> userOptional = userRepository.findById(userId);
    User user = new User();
    if(userOptional.isPresent()) {
      user = userOptional.get();    }
    return user;
  }

  public User findUserByName(String name){
    return userRepository.findByName(name);
  }

  public boolean checkExistUserById(Long userId){
    return userRepository.existsById(userId);
  }

  public boolean checkExistUserByName(String name){
    return userRepository.existsByName(name);
  }

  public boolean checkCorrectPassword(User user){
    String passwordFromLoginForm = user.getPassword();
    String passwordSavedInRepository = findUserByName(user.getName()).getPassword();
    return passwordFromLoginForm.equals(passwordSavedInRepository);
  }

  public void addVotedPost(Long userId, Post post, boolean upvoted){
    User user = findUserById(userId);
    VotedPost votedPost = new VotedPost(post, upvoted);
    ArrayList<VotedPost> votedPosts = user.getVotedPosts();
    votedPosts.add(votedPost);
    user.setVotedPosts(votedPosts);
    userRepository.save(user);
  }

  public void removeVotedPost(Long votingUserId, Long id) {
    User user = findUserById(votingUserId);
    ArrayList<VotedPost> votedPosts = user.getVotedPosts();
    VotedPost votedPost = findVotedPostById(votingUserId, id);
    votedPosts.remove(votedPost);
    save(user);
  }

  public VotedPost findVotedPostById (Long userId, Long id){
    User user = findUserById(userId);
    ArrayList<VotedPost> votedPosts = user.getVotedPosts();
    if(!votedPosts.isEmpty()) {
      for (VotedPost votedPost : votedPosts) {
        if (votedPost.getId().equals(id)) {
          return votedPost;
        }
      }
    }
    return null;
  }
}
