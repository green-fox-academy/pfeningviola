import java.awt.*;
import javax.swing.*;
import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Triangels {
    public static void mainDraw(Graphics graphics) {
        int a = 20;
        int numberBasic = 16;
        int numberHeight = numberBasic;
        int startX = 0;
        int startY = 320;
        int height = (int)(a * sqrt(3) / 2);

        for (int i = 0; i < numberHeight; i++) {
            startX = i * (a / 2);

            for (int j = 0; j < numberBasic; j++) {
                drawTriangle(graphics, startX, startY, a, height);
                startX += a;
            }
            numberBasic --;
            startY = startY - height;
        }
    }

    public static void drawTriangle(Graphics g, int startX, int startY, int size, int height) {
        g.setColor(Color.RED);
        g.drawLine(startX, startY, (startX + size), startY);
        g.drawLine((startX + size), startY, (startX + (size / 2)), (startY - height));
        g.drawLine((startX + (size / 2)), (startY - height), startX, startY);
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
