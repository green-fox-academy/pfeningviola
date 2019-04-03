package com.greenfoxacademy.rest.services;

import com.greenfoxacademy.rest.models.Log;
import com.greenfoxacademy.rest.models.LogList;
import com.greenfoxacademy.rest.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LogService {
  private LogRepository logRepository;

  @Autowired
  public LogService(LogRepository logRepository){
    this.logRepository = logRepository;
  }

  public void save(Log log){
    logRepository.save(log);
  }

  public ArrayList<Log> findAll(){
    ArrayList<Log> logs = new ArrayList<>();
    logRepository.findAll().forEach(logs::add);
    return logs;
  }

  public LogList createLogList(){
    ArrayList<Log> entries = findAll();
    return new LogList(entries, entries.size());
  }
}
