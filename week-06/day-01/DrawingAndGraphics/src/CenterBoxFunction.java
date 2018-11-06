import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class CenterBoxFunction {
    public static void mainDraw(Graphics graphics) {
        int x;
        for (int i = 0; i < 3; i++) {
            x = (int)(Math.random() * 160);
            squareDrawingToCenter(graphics, x);
        }
    }

    public static void squareDrawingToCenter(Graphics g, int squareSize) {
        g.setColor(new Color(0, 153, 153));
        g.drawRect(((WIDTH/ 2) - (squareSize / 2)), ((HEIGHT/ 2) - (squareSize / 2)), squareSize, squareSize);
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
