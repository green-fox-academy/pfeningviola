import java.util.Arrays;

public class ReverseList {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        for (int i = 0; i < aj.length - 1; i++) {
            for (int j = i + 1; j < aj.length; j++) {
                if (aj[i] < aj[j]) {
                    int toSort = aj[j];
                    aj[j] = aj[i];
                    aj[i] = toSort;
                }
            }
        }
        System.out.println(Arrays.toString(aj));
    }
}
