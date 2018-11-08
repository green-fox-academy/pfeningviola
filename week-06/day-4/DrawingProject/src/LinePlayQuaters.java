import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

import static java.lang.Math.sqrt;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class LinePlayQuaters {
    public static void mainDraw(Graphics graphics) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("How many quaters would you like to have? (It should be a square number): ");
        int numQuarters = scannerInt.nextInt();
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
        g.setColor(Color.ORANGE);
        int startXCoord = upperLeftX + (WIDTH / (n / div) / 8);
        int startYCoord = upperLeftY;
        int endXCoord = upperLeftX + (WIDTH / (n / div));
        int endYCoord = upperLeftY + (HEIGHT / (n / div) / 16);

        for (int i = 0; i < 14; i++) {
            g.drawLine(startXCoord, startYCoord, endXCoord, endYCoord);
            startXCoord += (WIDTH / (n / div) / 16);
            endYCoord += (WIDTH / (n / div) / 16);
        }

        g.setColor(Color.GREEN);
        startXCoord = upperLeftX;
        startYCoord = upperLeftY + (HEIGHT / (n / div) / 8);
        endXCoord = upperLeftX + (WIDTH / (n / div) / 16);
        endYCoord = upperLeftY + (HEIGHT / (n / div));

        for (int j = 0; j < 14; j++) {
            g.drawLine(startXCoord, startYCoord, endXCoord, endYCoord);
            startYCoord += (WIDTH / (n / div) / 16);
            endXCoord += (WIDTH / (n / div) / 16);
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


