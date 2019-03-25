package com.greenfoxacademy.redditproject.services;

import com.greenfoxacademy.redditproject.models.Post;
import com.greenfoxacademy.redditproject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
  private PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository){
    this.postRepository = postRepository;
  }

  public ArrayList<Post> findAllPost(){
    ArrayList<Post> posts = new ArrayList<>();
    postRepository.findAll().forEach(posts::add);
    return posts;
  }
}
