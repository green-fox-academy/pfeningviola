package main.java.animals;

public abstract class Animal {
  private String name;
  private int age;
  private int weight;
  private String gender;
  private String food;
  private String originalHabitat;
  private String endangeredLevel;

  public Animal(String name) {
    this.name = name;
  }

  public void eat() {
    System.out.println("The favorite food of " + name + " is the " + food);
  }

  public abstract String breed();

  public String getName() {
    return name;
  }
}
