package main.java.animals;

public class EggLayingAnimal extends Animal {

  public EggLayingAnimal(String name) {
    super(name);
  }

  @Override
  public String breed() {
    return "laying eggs";
  }
}
