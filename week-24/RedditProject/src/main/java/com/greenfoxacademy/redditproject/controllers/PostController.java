package com.greenfoxacademy.redditproject.controllers;

import com.greenfoxacademy.redditproject.models.Post;
import com.greenfoxacademy.redditproject.models.User;
import com.greenfoxacademy.redditproject.services.PostService;
import com.greenfoxacademy.redditproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/{userId}")
public class PostController {
  private UserService userService;
  private PostService postService;

  @Autowired
  public PostController(UserService userService, PostService postService){
    this.userService = userService;
    this.postService = postService;
  }

  @GetMapping({"", "/"})
  public String renderUserPage(Model model, @PathVariable Long userId){
    if (!userService.checkExistUserById(userId)) {
      model.addAttribute("noUserId", "User doesn't exist.");
      return "error";
    } else {
      ArrayList<Post> posts = postService.findAllPostByScoreOrderDesc();
      User user = userService.findUserById(userId);
      model.addAttribute("user", user);
      model.addAttribute("posts", posts);
      return "usermainpage";
    }
  }

  @GetMapping("/addpost")
  public String renderAddPostPage(Model model, @PathVariable Long userId) {
    if (!userService.checkExistUserById(userId)) {
      model.addAttribute("noUserId", "User doesn't exist.");
      return "error";
    } else {
      User user = userService.findUserById(userId);
      model.addAttribute("user", user);
      return "addpost";
    }
  }

  @PostMapping("/addpost")
  public String addPost(@ModelAttribute Post post, @PathVariable Long userId){
    postService.save(post);
    return "redirect:/" + userId;
  }

  @PostMapping("/upvote/{id}")
  public String upvotePost(Model model, @PathVariable Long userId, @PathVariable Long id){
    model.addAttribute("user", userService.findUserById(userId));
    model.addAttribute("posts", postService.findAllPostByScoreOrderDesc());

    if(postService.checkIfUsersPost(userId, id)) {
      model.addAttribute("ownPost", "");
      return "usermainpage";
    } else if (postService.checkIfAlreadyVoted(userId, id, true, false)){
      model.addAttribute("alreadyVoted", "");
      return "usermainpage";
    } else {
      postService.upvotePost(userId, id);
      return "redirect:/" + userId;
    }
  }

  @PostMapping("/downvote/{id}")
  public String downvotePost(Model model, @PathVariable Long userId, @PathVariable Long id){
    model.addAttribute("user", userService.findUserById(userId));
    model.addAttribute("posts", postService.findAllPost());

    if(postService.checkIfUsersPost(userId, id)) {
      model.addAttribute("ownPost", "");
      return "usermainpage";
    } else if (postService.checkIfAlreadyVoted(userId, id, false, true)){
      model.addAttribute("alreadyVoted", "");
      return "usermainpage";
    } else {
      postService.downvotePost(userId, id);
      return "redirect:/" + userId;
    }
  }

  @GetMapping("/myposts")
  public String renderOnlyUsersPosts(Model model, @PathVariable Long userId) {
    if (!userService.checkExistUserById(userId)) {
      model.addAttribute("noUserId", "User doesn't exist.");
      return "error";
    } else {
      User user = userService.findUserById(userId);
      model.addAttribute("user", user);
      return "myposts";
    }
  }

  @PostMapping("/delete/{id}")
  public String deletePost(Model model, @PathVariable Long userId, @PathVariable Long id){
    if (!userService.checkExistUserById(userId)) {
      model.addAttribute("noUserId", "User doesn't exist.");
      return "error";
    } else {
      postService.delete(id);
      return "redirect:/" + userId + "/myposts";
    }
  }

  @GetMapping("/edit/{id}")
  public String renderEditPostPage(Model model, @PathVariable Long userId, @PathVariable Long id){
    if (!userService.checkExistUserById(userId)) {
      model.addAttribute("noUserId", "User doesn't exist.");
      return "error";
    } else {
      model.addAttribute("post", postService.findPostById(id));
      model.addAttribute("user", userService.findUserById(userId));
      return "editpost";
    }
  }

  @PostMapping("/edit/{id}")
  public String editPost(@ModelAttribute Post post, @PathVariable Long userId, @PathVariable Long id){
    postService.save(post);
    return "redirect:/" + userId + "/myposts";
  }
}
