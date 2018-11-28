import javax.swing.*;
import java.awt.*;
import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class HexagonFactor {
  public static void mainDraw(Graphics graphics) {
    int size = 300;
    int limit = 4;
    int xCoord = 0;
    int yCoord = HEIGHT / 2;
    fractalHexagon(graphics, xCoord, yCoord, size, limit);
  }

  public static void fractalHexagon(Graphics graphics, int startX, int startY, int size, int limit) {
    drawingHexagonal(graphics, startX, startY, size);
    if (limit > 0) {
      fractalHexagon(graphics, (startX + (size / 4)), (int)(startY - (((size / 2) * sqrt(3)) / 2)), size / 2, limit - 1);
      fractalHexagon(graphics, (startX + (size / 4)), (int)(startY +  (((size / 2) * sqrt(3)) / 2)), size / 2, limit - 1);
      fractalHexagon(graphics, startX + size, startY, size / 2, limit - 1);
    }
  }

  public static void drawingHexagonal(Graphics g, int startX, int startY, int size) {
    int[] xCoordinates = {startX, (startX + (size / 2)), (startX + size + (size / 2)), (startX + (2 * size)), (startX + size + (size / 2)), (startX + (size / 2))};
    int[] yCoordinates = {startY, (int)(startY - (size * sqrt(3) / 2)), (int)(startY - (size * sqrt(3) / 2)), startY, (int)(startY + ((size * sqrt(3) / 2))), (int)(startY + (size * sqrt(3) / 2))};
    g.setColor(Color.BLUE);
    g.drawPolygon(xCoordinates, yCoordinates, 6);
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
