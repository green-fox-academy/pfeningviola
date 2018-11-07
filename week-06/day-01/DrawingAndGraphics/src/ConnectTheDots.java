import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ConnectTheDots {
    public static void mainDraw(Graphics graphics) {
        int[][] example1 = {{10, 10}, {290,  10}, {290, 290}, {10, 290}};
        int[][] example2 = {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};
        connectDots(graphics, example1);
        connectDots(graphics, example2);

    }

    public static void connectDots (Graphics g, int[][] coordinates) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < coordinates.length - 1; i++) {
            g.drawLine(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1]);
        }
        g.drawLine(coordinates[coordinates.length - 1][0], coordinates[coordinates.length - 1][1], coordinates[0][0], coordinates[0][1]);
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
