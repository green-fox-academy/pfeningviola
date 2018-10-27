import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        int[] numbers = {1, 11, 34, 52, 61, 1, 34, 61, 73, 11, 52, 1, 1};
        unique(numbers);
    }

    public static void unique(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int toSort = array[j];
                    array[j] = array[i];
                    array[i] = toSort;
                }
            }
        }

        int newLength = array.length;
        for (int h = 0; h < array.length - 1; h++) {
            if (array[h] == array[h + 1]) {
                newLength --;
            }
        }

        int[] result = new int[newLength];
        int index = 0;
        System.arraycopy(array, 0, result, 0, 1);
        for (int g = 0; g < array.length - 1; g++) {
            if (array[g] != array[g + 1]) {
                index++;
                System.arraycopy(array, (g + 1), result, index, 1);
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
