import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PurpleSteps3D {
    public static void mainDraw(Graphics graphics) {
        int xCoordinate = 10;
        int yCoordinate = 10;
        int width = 10;

        for (int i = 0; i < 6; i++) {
            graphics.setColor(new Color(204, 0, 255));
            graphics.fillRect(xCoordinate, yCoordinate, width, width);
            xCoordinate = xCoordinate + width;
            yCoordinate = yCoordinate + width;
            width = width + 10;
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
