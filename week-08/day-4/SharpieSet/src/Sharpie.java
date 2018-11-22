public class Sharpie {
  private String color;
  private float width;
  private float inkAmount;

  public Sharpie (String color, float width) {
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  }

  public Sharpie (float inkAmount) {
    this.color = "red";
    this.width = 2.5f;
    this.inkAmount = inkAmount;
  }

  public void use() {
    inkAmount -= 10;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public float getWidth() {
    return width;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public float getInkAmount() {
    return inkAmount;
  }

  public void setInkAmount(float inkAmount) {
    this.inkAmount = inkAmount;
  }

  @Override
  public String toString() {
    return "Sharpie{" +
        "color='" + color + '\'' +
        ", width=" + width +
        ", inkAmount=" + inkAmount +
        '}';
  }
}
