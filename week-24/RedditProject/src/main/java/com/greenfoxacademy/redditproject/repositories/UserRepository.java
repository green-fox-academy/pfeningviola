package com.greenfoxacademy.redditproject.repositories;

import com.greenfoxacademy.redditproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByName(String name);
  boolean existsByName(String name);
}
