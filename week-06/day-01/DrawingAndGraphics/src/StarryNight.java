import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StarryNight {
    public static void mainDraw(Graphics graphics) {
        int starsNumber = (int)(100 + (Math.random() * 500));

        for (int i = 0; i < starsNumber; i++) {
            int starsSize = (int)(1 + (Math.random() * 3));
            int xCoord = (int)(Math.random() * (WIDTH - starsSize));
            int yCoord = (int)(Math.random() * (HEIGHT - starsSize));
            int color = (int)(30 + (Math.random() * 210));

            graphics.setColor(new Color(color, color, color));
            graphics.fillRect(xCoord, yCoord, starsSize, starsSize);
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
            this.setBackground(Color.BLACK);
            mainDraw(graphics);
        }
    }
}
