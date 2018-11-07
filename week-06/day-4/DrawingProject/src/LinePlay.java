import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LinePlay {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int xCoord = 40;
        int yCoord = 20;

        for (int i = 0; i < 14; i++) {
            graphics.drawLine(xCoord, 0, WIDTH, yCoord);
            xCoord += 20;
            yCoord += 20;
        }

        graphics.setColor(Color.GREEN);
        yCoord = 40;
        xCoord = 20;

        for (int j = 0; j < 14; j++) {
            graphics.drawLine(0, yCoord, xCoord, HEIGHT);
            xCoord += 20;
            yCoord += 20;
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
