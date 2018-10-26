import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        String[] abc = {"first", "second", "third"};
        String toSwap = abc[0];
        abc[0] = abc[2];
        abc[2] = toSwap;
        System.out.println(Arrays.toString(abc));
    }
}
