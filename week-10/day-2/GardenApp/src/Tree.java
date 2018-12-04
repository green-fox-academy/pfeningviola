public class Tree extends Plant {

  public Tree(String color, double waterLevel){
    super(color, waterLevel);
    setAbsorbtionPart(0.4);
    setNeedsWaterLevel(10);
    setPlantType("Tree");
  }
}
