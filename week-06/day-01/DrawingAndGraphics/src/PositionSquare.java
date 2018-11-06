import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PositionSquare {
    public static void mainDraw(Graphics graphics) {
        int xCoordinates;
        int yCoordinates;
        for (int i = 0; i < 3; i++) {
            xCoordinates = (int)(Math.random() * 270);
            yCoordinates = (int)(Math.random() * 270);
            squareDrawing(graphics, xCoordinates, yCoordinates);
        }
    }

    public static void squareDrawing(Graphics g, int startX, int startY) {
        g.setColor(Color.ORANGE);
        g.drawRect(startX, startY, 50,50);
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