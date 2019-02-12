package com.greenfoxacademy.books.models;

public class Book {
  private int id;
  private static int nextId = 0;
  private String title;
  private String author;
  private int releaseYear;

  public Book(String title, String author, int releaseYear){
    this.title = title;
    this.author = author;
    this. releaseYear = releaseYear;
    nextId = nextId + 1;
    this.id = nextId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNextId() {
    return nextId;
  }

  public void setNextId(int nextId) {
    this.nextId = nextId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
