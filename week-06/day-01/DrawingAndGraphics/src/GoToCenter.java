import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GoToCenter {
    public static void mainDraw(Graphics graphics) {
        ArrayList<Integer> xCoordinates = new ArrayList<>();
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        
        for (int j = 0; j < 3; j++) {
            xCoordinates.add(j,(int) (Math.random() * 320));
            yCoordinates.add(j,(int) (Math.random() * 320));
        }

        for (int i = 0; i < xCoordinates.size(); i++) {
            lineDrawing(graphics, xCoordinates.get(i), yCoordinates.get(i));
        }
    }

    public static void lineDrawing (Graphics g, int startX, int startY) {
        g.setColor(Color.MAGENTA);
        g.drawLine(startX, startY, 160, 160);
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
