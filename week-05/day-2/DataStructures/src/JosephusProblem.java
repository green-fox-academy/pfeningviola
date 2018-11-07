import java.util.ArrayList;
import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("How many people should be in the circle?");
        int number = scannerInt.nextInt();
        System.out.println("The winning seat is: " + solvingJosephusProblem(number));
        System.out.println("The winning seat is: " + solvingJosephusProblem2(number));
    }

    public static int solvingJosephusProblem (int peopleNumber) {
        ArrayList<Integer> group = new ArrayList<>();
        for (int i = 0; i < peopleNumber; i++) {
            group.add(i, i + 1);
        }

        int indexToRemove = 1;
        for (int j = 0; j < peopleNumber; j++) {
            group.remove(indexToRemove);

            if (group.size() == 1) {
                break;
            } else if (indexToRemove == group.size()) {
                indexToRemove = 0;
            } else if (indexToRemove == group.size() - 1) {
                indexToRemove = -1;
            }
            indexToRemove ++;
        }
        return group.get(0);
    }

    public static int solvingJosephusProblem2 (int n) {
        int valueOfL = n - Integer.highestOneBit(n);
        int safePosition = 2 * valueOfL  + 1;

        return safePosition;
    }
}
