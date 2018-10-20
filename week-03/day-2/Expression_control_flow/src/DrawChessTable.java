
public class DrawChessTable {
    public static void main(String[] args) {
        String black = "%";
        String white = " ";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    System.out.print(black + white);
                } else {
                    System.out.print(white + black);
                }
            }
            System.out.println();
        }
    }
}
