import java.awt.*;

public class Lines {
  private int startX;
  private int startY;
  private int length;
  private int endX;
  private int endY;
  Graphics graphics;


  public Lines (int startX, int startY, int endX, int endY, Graphics graphics) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
    this.graphics = graphics;
    drawLine(graphics, startX, startY, endX, endY);
  }

  public static void drawLine (Graphics graphics, int startX, int startY, int endX, int endY){
    graphics.drawLine(startX, startY, endX, endY);
  }
}
