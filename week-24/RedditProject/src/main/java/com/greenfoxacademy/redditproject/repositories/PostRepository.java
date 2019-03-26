package com.greenfoxacademy.redditproject.repositories;

import com.greenfoxacademy.redditproject.models.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
