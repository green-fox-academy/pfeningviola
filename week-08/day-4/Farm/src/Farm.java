import java.util.ArrayList;

public class Farm {
  private ArrayList<Animal> listOfAnimals;
  private int farmSize;

  public Farm(int farmSize){
    this.listOfAnimals = new ArrayList<>();
    this.farmSize = farmSize;
  }

  public void add(Animal animal) {
    this.listOfAnimals.add(animal);
  }

  public void breed() {
    if (farmSize > listOfAnimals.size()) {
      listOfAnimals.add(new Animal());
    } else {
      System.out.println("The farm is full, there isn't any space.");
    }
  }

  public void slaughter() {
    int minHunger = 100;
    for (int i = 0; i < listOfAnimals.size(); i++) {
      if (listOfAnimals.get(i).getHunger() < minHunger) {
        minHunger = listOfAnimals.get(i).getHunger();
      }
    }
    int i = 0;
    while (listOfAnimals.get(i).getHunger() != minHunger) {
      i++;
    }
    listOfAnimals.remove(listOfAnimals.get(i));
  }

  public ArrayList<Animal> getListOfAnimals() {
    return listOfAnimals;
  }

  public void setListOfAnimals(ArrayList<Animal> listOfAnimals) {
    this.listOfAnimals = listOfAnimals;
  }

  public int getFarmSize() {
    return farmSize;
  }

  public void setFarmSize(int farmSize) {
    this.farmSize = farmSize;
  }

  @Override
  public String toString() {
    return "Farm{" +
        "listOfAnimals=" + listOfAnimals;
  }
}
