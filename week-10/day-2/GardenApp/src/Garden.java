import java.util.ArrayList;

public class Garden {
  ArrayList<Plant> plants;
  int numberOfThirstyPlants;

  public Garden(){
    this.plants = new ArrayList<>();
    this.numberOfThirstyPlants = 0;
  }

  public void add(Plant plant){
    plants.add(plant);
  }

  public void waterTheGarden(int waterAmount) {
    countThirstyPlants();
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).checkIfNeedsWater()) {
        plants.get(i).watering(waterAmount / numberOfThirstyPlants);
      }
    }
  }

  public int countThirstyPlants() {
    numberOfThirstyPlants = 0;
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).checkIfNeedsWater()) {
        numberOfThirstyPlants++;
      }
    }
    return numberOfThirstyPlants;
  }

  @Override
  public String toString() {
    String toPrint = "";
    for (Plant plant : plants) {
      toPrint += plant.toString() + "\n" ;
    }
    return toPrint;
  }
}
