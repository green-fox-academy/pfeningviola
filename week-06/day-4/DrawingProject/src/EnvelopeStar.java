import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EnvelopeStar {
    public static void mainDraw(Graphics graphics) {
        int lineDistance = 10;
        int startPointUp = (WIDTH / 2) - (14 * lineDistance);
        int startPointDown = (WIDTH / 2) + (14 * lineDistance);
        int startPointLeft = (HEIGHT / 2) - (14 * lineDistance);
        
        drawingEnvelopeStar1(graphics, 160, startPointUp, lineDistance);
        drawingEnvelopeStar2(graphics, startPointLeft, 160, lineDistance);

        graphics.setColor(Color.GREEN);
        graphics.drawLine(160, startPointUp, 160, startPointDown);
    }

    public static void drawingEnvelopeStar1(Graphics g, int topX, int topY, int lineDist) {
        g.setColor(Color.GREEN);
        for (int h = 0; h < 2; h++) {
            for (int i = 0; i < 14; i++) {
                g.drawLine(topX, topY, 160 - lineDist, 160);
                g.drawLine(topX, topY, 160 + lineDist, 160);
                lineDist += 10;
                if (h == 1) {
                    topY -= 10;
                } else {
                    topY += 10;
                }
            }
            lineDist = 10;
            topY = (WIDTH / 2) + (14 * lineDist);
        }
    }

    public static void drawingEnvelopeStar2(Graphics g, int topX, int topY, int lineDist) {
        g.setColor(Color.GREEN);
        for (int h = 0; h < 2; h++) {
            for (int i = 0; i < 14; i++) {
                g.drawLine(topX, topY, 160, 160 - lineDist);
                g.drawLine(topX, topY, 160, 160 + lineDist);
                lineDist += 10;
                if (h == 1) {
                    topX -= 10;
                } else {
                    topX += 10;
                }
            }
            lineDist = 10;
            topX = (HEIGHT / 2) + (14 * lineDist);
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
