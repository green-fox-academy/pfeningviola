import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class HorizontalLines {
    public static void mainDraw(Graphics graphics) {
        ArrayList<Integer> xCoordinates = new ArrayList<>(Arrays.asList(60, 120, 230));
        ArrayList<Integer> yCoordinates = new ArrayList<>(Arrays.asList(50, 280, 145));
        for(int i = 0; i < xCoordinates.size(); i++) {
            drawingHorizantalLines(graphics, xCoordinates.get(i), yCoordinates.get(i));
        }
    }

    public static void drawingHorizantalLines(Graphics g, int startX, int startY) {
        g.setColor(new Color(115, 38, 77));
        g.drawLine(startX, startY, (startX + 50), startY);
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
