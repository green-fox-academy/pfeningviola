public class DiagonalMatrix {

    public static void main(String[] args) {
        int[][] multiArray = new int [4][4];
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                if (i == j) {
                    multiArray[i][j] = 1;
                } else {
                    multiArray[i][j] = 0;
                }
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
