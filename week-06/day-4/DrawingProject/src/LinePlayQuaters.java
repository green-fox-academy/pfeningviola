import java.awt.*;
import javax.swing.*;
import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LinePlayQuaters {
    public static void mainDraw(Graphics graphics) {
        int numQuarters = 9;
        int quoterStartX = 0;
        int quoterStartY = 0;
        int divisor = (int)sqrt(numQuarters);

        for (int i = 0; i < divisor; i++) {
            for(int j = 0; j < divisor; j++) {
                drawingLinePlay(graphics, numQuarters, quoterStartX, quoterStartY, divisor);
                quoterStartX += WIDTH / (numQuarters / divisor);
            }
            quoterStartY += HEIGHT / (numQuarters / divisor);
            quoterStartX = 0;
        }
    }

    public static void drawingLinePlay (Graphics g, int n, int upperLeftX, int upperLeftY, int div) {

        int startXCoord = upperLeftX + (WIDTH / (n / div) / 8);
        int startYCoord = upperLeftY;
        int endXCoord = upperLeftX + (WIDTH / (n / div));
        int endYCoord = upperLeftY + (HEIGHT / (n / div) / 16);

        for (int h = 0; h < 28; h++) {
            if (h < 14) {
                g.setColor(Color.ORANGE);
                g.drawLine(startXCoord, startYCoord, endXCoord, endYCoord);
                startXCoord += (WIDTH / (n / div) / 16);
                endYCoord += (WIDTH / (n / div) / 16);
            } else if (h == 14) {
                startXCoord = upperLeftX;
                startYCoord = upperLeftY + (HEIGHT / (n / div) / 8);
                endXCoord = upperLeftX + (WIDTH / (n / div) / 16);
                endYCoord = upperLeftY + (HEIGHT / (n / div));
                g.setColor(Color.GREEN);
                g.drawLine(startXCoord, startYCoord, endXCoord, endYCoord);
            } else {
                startYCoord += (WIDTH / (n / div) / 16);
                endXCoord += (WIDTH / (n / div) / 16);
                g.setColor(Color.GREEN);
                g.drawLine(startXCoord, startYCoord, endXCoord, endYCoord);
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
