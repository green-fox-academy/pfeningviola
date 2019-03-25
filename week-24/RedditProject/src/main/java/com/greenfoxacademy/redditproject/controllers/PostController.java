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
      ArrayList<Post> posts = postService.findAllPost();
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

}
