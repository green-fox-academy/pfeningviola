import java.util.Arrays;
import java.util.Scanner;

public class SortThatList {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        System.out.println("How many numbers would you like to enter? ");
        int howMany = scannerInt.nextInt();
        int[] numbers = new int[howMany];

        for (int i = 0; i < howMany; i++) {
            System.out.println("Enter a number: ");
            numbers[i] = scannerInt.nextInt();
        }
        boolean length = (howMany > 5);
        
        bubble(numbers);
        advencedBubble(numbers, length);
    }

    public static void bubble(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            for (int g = j + 1; g < array.length; g++) {
                if (array[j] > array[g]) {
                    int toSort = array[g];
                    array[g] = array[j];
                    array[j] = toSort;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void advencedBubble(int[] array, boolean length) {
        if (length == true){
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] < array[j]) {
                        int toSort = array[j];
                        array[j] = array[i];
                        array[i] = toSort;
                    }
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
