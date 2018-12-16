public class Sharpie {
  private String color;
  private float width;
  private float inkAmount;

  public Sharpie (String color, float width) {
    this.color = color;
    this.width = width;
    this.inkAmount = 100;
  }

  public float use() {
    if (inkAmount > 0) {
      return inkAmount--;
    } else {
      return 0;
    }

  }

  public float getInkAmount() {
    return inkAmount;
  }
}
