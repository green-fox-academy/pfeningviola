import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FunctionToCenter {
    public static void mainDraw(Graphics graphics) {
        int xCoord = 0;
        int yCoord = 0;
        for (int i = 0; i < (WIDTH / 20); i++) {
            lineDrawing(graphics, xCoord, 0);
            lineDrawing(graphics, 0, yCoord);
            lineDrawing(graphics, xCoord, 320);
            lineDrawing(graphics, 320, yCoord);
            
            xCoord += 20;
            yCoord += 20;
        }
        lineDrawing(graphics, 320, 320);
    }

    public static void lineDrawing (Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.drawLine(x, y, 160, 160);
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
