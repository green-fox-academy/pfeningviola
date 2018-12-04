import java.util.ArrayList;

public class Garden {
  ArrayList<Plant> plants;
  int numberOfDirstyPlants;

  public Garden(){
    this.plants = new ArrayList<>();
    this.numberOfDirstyPlants = 0;
  }

  public void add(Plant plant){
    plants.add(plant);
  }

  public void waterTheGarden(int waterAmount) {
    countDirstyPlants();
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).checkIfNeedsWater()) {
        plants.get(i).watering(waterAmount / numberOfDirstyPlants);
      }
    }
  }

  public int countDirstyPlants() {
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).checkIfNeedsWater()) {
        numberOfDirstyPlants++;
      }
    }
    return numberOfDirstyPlants;
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
