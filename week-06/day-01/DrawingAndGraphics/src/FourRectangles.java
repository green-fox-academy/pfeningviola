import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FourRectangles {
    public static void mainDraw(Graphics graphics) {
        ArrayList<Integer> xCoordinates = new ArrayList<>();
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        ArrayList<Integer> widths = new ArrayList<>();
        ArrayList<Integer> heights = new ArrayList<>();
        ArrayList<Integer> colorCodeR = new ArrayList<>();
        ArrayList<Integer> colorCodeG = new ArrayList<>();
        ArrayList<Integer> colorCodeB = new ArrayList<>();


        for (int j = 0; j < 4; j++) {
            widths.add(j, (int)(Math.random() * 320));
            heights.add(j, (int)(Math.random() * 320));
            xCoordinates.add(j,(int)(Math.random() * (320 - widths.get(j))));
            yCoordinates.add(j,(int)(Math.random() * (320 - heights.get(j))));
            colorCodeR.add(j, (int)(Math.random() * 256));
            colorCodeG.add(j, (int)(Math.random() * 256));
            colorCodeB.add(j, (int)(Math.random() * 256));
        }

        for (int i = 0; i < xCoordinates.size(); i++) {
            graphics.setColor(new Color(colorCodeR.get(i), colorCodeG.get(i), colorCodeB.get(i)));
            graphics.drawRect(xCoordinates.get(i), yCoordinates.get(i), widths.get(i), heights.get(i));
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
