import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Checkerboard {
    public static void mainDraw(Graphics graphics) {
        int xCoord = 0;
        int yCoord = 0;
        int width = 20;

        for (int i = 0; i < (WIDTH / width); i++) {
            for (int j = 0; j < (WIDTH / width); j++) {
                graphics.fillRect(xCoord, yCoord, width, width);
                xCoord += (width * 2);
            }
            yCoord += width;
            if (i % 2 == 0) {
                xCoord = width;
            } else {
                xCoord = 0;
            }
        }
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
