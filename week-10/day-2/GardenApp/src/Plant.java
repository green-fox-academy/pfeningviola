public class Plant {
  private String color;
  private String plantType;
  private double waterLevel;
  private double absorptionPart;
  private int needsWaterLevel;

  public Plant(String color, double waterLevel) {
    this.color = color;
    this.waterLevel = waterLevel;
    this.absorptionPart = 1;
  }

  public void watering(int waterAmount) {
    waterLevel += (waterAmount * absorptionPart);
  }

  public boolean checkIfNeedsWater() {
    return waterLevel < needsWaterLevel;
  }

  public String printNeedsWater() {
    if (waterLevel < needsWaterLevel) {
      return " needs water.";
    } else {
      return " doesn't need water.";
    }
  }

  public void setAbsorptionPart(double absorptionPart) {
    this.absorptionPart = absorptionPart;
  }

  public void setNeedsWaterLevel(int needsWaterLevel) {
    this.needsWaterLevel = needsWaterLevel;
  }

  public void setWaterLevel(int waterLevel) {
    this.waterLevel = waterLevel;
  }

  public double getWaterLevel() {
    return waterLevel;
  }

  public void setPlantType(String plantType) {
    this.plantType = plantType;
  }

  @Override
  public String toString() {
    return "The " + color + " " + plantType + printNeedsWater();
  }
}
