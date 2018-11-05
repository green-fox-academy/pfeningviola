import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class ColoredBox {
    public static void mainDraw(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.drawLine(50, 50, 50, 200);

        graphics.setColor(Color.ORANGE);
        graphics.drawLine(50, 200, 200, 200);

        graphics.setColor(Color.PINK);
        graphics.drawLine(200, 200, 200, 50);

        graphics.setColor(new Color(0, 153, 0));
        graphics.drawLine(200, 50, 50, 50);
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
