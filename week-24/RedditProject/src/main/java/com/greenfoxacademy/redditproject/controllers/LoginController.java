package com.greenfoxacademy.redditproject.controllers;

import com.greenfoxacademy.redditproject.models.User;
import com.greenfoxacademy.redditproject.services.PostService;
import com.greenfoxacademy.redditproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
  private UserService userService;
  private PostService postService;
  private Boolean voteWithoutLogin;

  @Autowired
  public LoginController(UserService userService, PostService postService) {
    this.userService = userService;
    this.postService = postService;
  }

  @GetMapping("/")
  public String renderMainPage(Model model) {
    model.addAttribute("posts", postService.findAllPost());
    model.addAttribute("voteWithoutLogin", voteWithoutLogin);
    voteWithoutLogin = false;
    return "main";
  }

  @GetMapping("/login")
  public String renderLoginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute User userFromForm, Model model) {
    if (userService.checkExistUserByName(userFromForm.getName())) {
      if (userService.checkCorrectPassword(userFromForm)) {
        User user = userService.findUserByName(userFromForm.getName());
        return "redirect:/" + user.getUserId();
      } else {
        model.addAttribute("wrongPassword", "The password is not correct.");
        return "login";
      }
    } else {
      model.addAttribute("noUser", "You have provided an username that is not registered.");
      return "login";
    }
  }

  @GetMapping("/register")
  public String renderRegisterPage(Model model, @ModelAttribute User user) {
    model.addAttribute("user", user);
    return "register";
  }

  @PostMapping("/register")
  public String register(Model model, @ModelAttribute User userFromForm, @RequestParam String passwordAgain) {
    if (!userFromForm.getPassword().equals(passwordAgain)) {
      model.addAttribute("notMatchingPasswords", "The passwords do not match.");
      model.addAttribute("user", userFromForm);
      return "register";
    } else {
      if (userService.checkExistUserByName(userFromForm.getName())) {
        model.addAttribute("alreadyExistingUser", "This username is already used. Choose other name!");
        return "register";
      } else {
        userService.save(userFromForm);
        return "redirect:/" + userFromForm.getUserId();
      }
    }
  }

  @PostMapping("/vote")
  public String voteWithoutLogin() {
    voteWithoutLogin = true;
    return "redirect:/";
  }
}

