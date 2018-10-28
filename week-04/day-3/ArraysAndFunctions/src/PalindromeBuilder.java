import java.util.Arrays;
import java.util.Scanner;

public class PalindromeBuilder {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Please, enter a word: ");
        String input = scannerString.nextLine();

        System.out.println(createPalindrome(input));
    }

    public static String createPalindrome(String word) {
        char[] letters = word.toCharArray();
        char[] palindromeLetters = Arrays.copyOf(letters, letters.length * 2);
        int reverseChar = 0;
        for (int i = 0; i < letters.length; i++) {
            System.arraycopy(letters, (letters.length - 1 - i), palindromeLetters, (letters.length + reverseChar), 1);
            reverseChar ++;
        }
        String palindromeWord = new String(palindromeLetters);
        return palindromeWord;
    }
}
