package com.greenfoxacademy.programmersfoxclub.repositories;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ImageRepository {
  private ArrayList<String> foxImages;

  public ImageRepository(){
    this.foxImages = new ArrayList<>();
    foxImages.add("/img/greenfox3.png");
    foxImages.add("/img/redfox.png");
    foxImages.add("/img/yellowfox.png");
    foxImages.add("/img/arcticfox.png");
    foxImages.add("/img/indianfox.png");
    foxImages.add("/img/bluefox.png");
  }

  public ArrayList<String> findAllFoxImages() {
    return foxImages;
  }

  public void setFoxImages(ArrayList<String> foxImages) {
    this.foxImages = foxImages;
  }
}
