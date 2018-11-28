import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LinesInSquare {
  public static void mainDraw(Graphics graphics) {
    int size = WIDTH;
    int limit = 4;
    int xCoord = 0;
    int yCoord = 0;
    drawFractal(graphics, xCoord, yCoord, size, limit);
  }

  public static void drawFractal(Graphics graphics, int xCoord, int yCoord, int size, int limit) {
    drawLines(graphics, xCoord, yCoord, size);
    if (limit > 0) {
      drawFractal(graphics, xCoord + size / 3, yCoord, size / 3, limit - 1);
      drawFractal(graphics, xCoord, yCoord + size / 3, size / 3, limit - 1);
      drawFractal(graphics, xCoord + size / 3, yCoord + (size / 3 * 2), size / 3, limit - 1);
      drawFractal(graphics, xCoord + (size / 3 * 2), yCoord + size / 3, size / 3, limit - 1);
    }
  }

  public static void drawLines(Graphics graphics, int xCoord, int yCoord, int size) {
    graphics.drawLine(xCoord, yCoord + size / 3, xCoord + size, yCoord + size / 3);
    graphics.drawLine(xCoord, yCoord + (size / 3 * 2), xCoord + size, yCoord + (size / 3 * 2));
    graphics.drawLine(xCoord + (size / 3), yCoord, xCoord + (size / 3), yCoord + size);
    graphics.drawLine(xCoord + (size / 3 * 2), yCoord, xCoord + (size / 3 * 2), yCoord + size);
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
      this.setBackground(Color.YELLOW);
      mainDraw(graphics);
    }
  }
}
