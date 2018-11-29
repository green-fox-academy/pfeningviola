import javax.swing.*;
import java.awt.*;
import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class KochLineMain {
  public static void mainDraw(Graphics graphics) {
    int limit = 4;
    int length = 600;
    int startX = 0;
    int startY = 300;
    int endX = 600;
    int endY = 300;
    drawSnowflake(startX, startY, endX, endY, length, limit, graphics);

  }

  public static void drawSnowflake(int startX, int startY, int endX, int endY, int length, int limit, Graphics graphics) {
    Lines line = new Lines(startX, startY, endX, endY, length, graphics);
    if (limit > 0) {
      drawSnowflake(startX, startY, startX + (length / 3), startY, length / 3, limit - 1, graphics);
      drawSnowflake(startX + (length / 3), startY, (startX + (length / 3) + (length / 6)), (int)(startY - (((length / 3 * sqrt(3)) / 2))), length / 3, limit - 1, graphics);
      drawSnowflake((startX + (length / 3) + (length / 6)), (int)(startY - (((length / 3 * sqrt(3)) / 2))), startX + (2 * length / 3), startY, length / 3, limit - 1, graphics);
      drawSnowflake(startX + (2 * length / 3), startY, startX + length, startY, length / 3, limit - 1, graphics);
    }
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
