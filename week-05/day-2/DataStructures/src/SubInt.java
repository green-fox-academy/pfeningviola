import java.util.ArrayList;

public class SubInt {
    public static void main(String[] args) {
        System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
    }

    public static ArrayList<Integer> subInt(int number, int[] array) {
        ArrayList<Integer> index = new ArrayList<>();
        String numberToString = String.valueOf(number);
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).contains(numberToString)) {
                index.add(i);
            }
        }
        return index;
    }
}

