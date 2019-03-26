package com.greenfoxacademy.redditproject.services;

import com.greenfoxacademy.redditproject.models.Post;
import com.greenfoxacademy.redditproject.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

  public void save(Post post){
    postRepository.save(post);
  }

  public void upvotePost(Long id){
    Post post = findPostById(id);
    post.setScore(post.getScore() + 1);
    postRepository.save(post);
  }

  public void downvotePost(Long id){
    Post post = findPostById(id);
    post.setScore(post.getScore() - 1);
    postRepository.save(post);
  }

  public Post findPostById(Long id){
    Optional<Post> postOptional = postRepository.findById(id);
    Post post = new Post();
    if(postOptional.isPresent()) {
      post = postOptional.get();    }
    return post;
  }
}
