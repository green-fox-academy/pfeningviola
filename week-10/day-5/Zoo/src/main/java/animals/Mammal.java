package main.java.animals;

public class Mammal extends Animal {
  private int gestationPeriod;
  private String typeOfFur;

  public Mammal(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "pushing miniature versions out";
  }
}
