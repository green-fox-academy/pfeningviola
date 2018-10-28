import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Please, enter a word: ");
        String input1 = scannerString.nextLine();
        System.out.println("Please, enter another word: ");
        String input2 = scannerString.nextLine();

        System.out.println("The two words are anagram: " + anagram(input1, input2));
    }

    public static boolean anagram(String word1, String word2) {
        char[] toLetters1 = word1.toCharArray();
        char[] toLetters2 = word2.toCharArray();

        for (int i = 0; i < toLetters1.length - 1; i++) {
            for (int j = i + 1; j < toLetters1.length; j++) {
                if (toLetters1[i] > toLetters1[j]) {
                    char toSort1 = toLetters1[j];
                    toLetters1[j] = toLetters1[i];
                    toLetters1[i] = toSort1;
                }
            }
        }
        for (int g = 0; g < toLetters2.length - 1; g++) {
            for (int h = g + 1; h < toLetters2.length; h++) {
                if (toLetters2[g] > toLetters2[h]) {
                    char toSort2 = toLetters2[h];
                    toLetters2[h] = toLetters2[g];
                    toLetters2[g] = toSort2;
                }
            }
        }
        boolean equal = Arrays.equals(toLetters1, toLetters2);
        return equal;
    }
}
