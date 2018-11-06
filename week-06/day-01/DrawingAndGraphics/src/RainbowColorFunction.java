import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class RainbowColorFunction {
    public static void mainDraw(Graphics graphics) {
        int x;
        int[] color = new int[3];
        for (int i = 0; i < 20; i++) {

            for (int j = 0; j < 3; j++) {
                color[j] =(int)(Math.random() * 256);
            }

            x = (int)(Math.random() * 320);
            drawingRainbowSquares(graphics, x, color);
        }
    }

    public static void drawingRainbowSquares (Graphics g, int squareSize, int[] rgb) {
        g.setColor(new Color(rgb[0], rgb[1], rgb[2]));
        g.fillRect(((WIDTH/ 2) - (squareSize / 2)), ((HEIGHT/ 2) - (squareSize / 2)), squareSize, squareSize);
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
