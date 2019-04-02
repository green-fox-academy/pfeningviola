package com.greenfoxacademy.rest.repositories;

import com.greenfoxacademy.rest.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}
