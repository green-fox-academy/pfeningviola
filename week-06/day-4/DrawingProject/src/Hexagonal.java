import java.awt.*;
import javax.swing.*;
import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Hexagonal {
    public static void mainDraw(Graphics graphics) {
        int a = 20;
        int xCoord = 30;
        int yCoord = 100;
        int yCoordMoving = yCoord;
        int hexNumberInColumn = 4;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < hexNumberInColumn; j++) {
                drawingHexagonal(graphics, xCoord, yCoordMoving, a);
                yCoordMoving += (int)(a * sqrt(3));
            }

            if (i < 3) {
                hexNumberInColumn ++;
                yCoordMoving = yCoord - ((int)(a * sqrt(3) / 2));
                yCoord -= ((int)(a * sqrt(3) / 2));
            } else {
                hexNumberInColumn --;
                yCoordMoving = yCoord + ((int)(a * sqrt(3) / 2));
                yCoord += ((int)(a * sqrt(3) / 2));
            }
            xCoord = xCoord + (a + (a / 2));
        }
    }

    public static void drawingHexagonal(Graphics g, int startX, int startY, int size) {
        int[] xCoordinates = {startX, (startX + (size / 2)), (startX + size + (size / 2)), (startX + (2 * size)), (startX + size + (size / 2)), (startX + (size / 2))};
        int[] yCoordinates = {startY, (startY - ((int) (size * sqrt(3) / 2))), (startY - ((int) (size * sqrt(3) / 2))), startY, (startY + ((int) (size * sqrt(3) / 2))), (startY + ((int) (size * sqrt(3) / 2)))};
        g.setColor(Color.BLUE);
        g.drawPolygon(xCoordinates, yCoordinates, 6);
    }

    static int WIDTH = 320;
    static int HEIGHT = 320;

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
