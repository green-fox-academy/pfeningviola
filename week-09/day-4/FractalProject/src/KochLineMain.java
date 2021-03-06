import javax.swing.*;
import java.awt.*;
import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class KochLineMain {
  public static void mainDraw(Graphics graphics) {
    int limit = 5;
    int startX = 0;
    int startY = 300;
    int endX = 600;
    int endY = 300;
    drawKochLine(startX, startY, endX, endY, limit, graphics);

  }

  public static void drawKochLine(int startX, int startY, int endX, int endY, int limit, Graphics graphics) {

    if (limit == 1) {
      Lines line = new Lines(startX, startY, endX, endY, graphics);
    } else {
      int dX = endX - startX;
      int dY = endY - startY;
      int x2 = startX + (dX / 3);
      int y2 = startY +  (dY / 3);
      int x3 = (int)((startX + (endX - startX) / 2) - ((sqrt(3) / 6) * (startY - endY)));
      int y3 = (int)((startY + (endY - startY) / 2) - ((sqrt(3) / 6 ) * (endX - startX)));
      int x4 = startX + dX * 2 / 3;
      int y4 = startY + dY * 2 / 3;

      setColor(graphics);
      drawKochLine(startX, startY, x2, y2, limit - 1, graphics);
      drawKochLine(x2, y2, x3, y3, limit - 1, graphics);
      drawKochLine(x3, y3, x4, y4, limit - 1, graphics);
      drawKochLine(x4, y4, endX, endY, limit - 1, graphics);
    }
  }

  public static void setColor(Graphics graphics){
    int r = (int)(Math.random() * 255);
    int g = (int)(Math.random() * 255);
    int b = (int)(Math.random() * 255);

    graphics.setColor(new Color(r, g, b));
  }

  static int WIDTH = 600;
  static int HEIGHT = 600;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}
