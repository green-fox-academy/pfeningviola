public class Flower extends Plant {

  public Flower(String color, double waterLevel){
    super(color, waterLevel);
    setAbsorptionPart(0.75);
    setNeedsWaterLevel(5);
    setPlantType("Flower");
  }
}
