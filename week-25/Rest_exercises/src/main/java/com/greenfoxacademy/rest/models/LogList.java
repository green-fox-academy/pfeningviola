package com.greenfoxacademy.rest.models;

import java.util.ArrayList;

public class LogList {
  private ArrayList<Log> entries;
  private int entry_count;

  public LogList(ArrayList<Log> entries, int entry_count){
    this.entries = entries;
    this. entry_count = entry_count;
  }

  public ArrayList<Log> getEntries() {
    return entries;
  }

  public void setEntries(ArrayList<Log> entries) {
    this.entries = entries;
  }

  public int getEntry_count() {
    return entry_count;
  }

  public void setEntry_count(int entry_count) {
    this.entry_count = entry_count;
  }
}
