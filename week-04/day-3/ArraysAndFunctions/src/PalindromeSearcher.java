import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PalindromeSearcher {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        System.out.println("Please, enter a word: ");
        String input = scannerString.nextLine();

        System.out.println(searchPalindrome(input));
    }

    public static ArrayList<String> searchPalindrome(String word) {
        char[] letters = word.toCharArray();
        int palindromeLength = 3;
        boolean isAPalindrome = true;
        ArrayList<String> palindromeWords = new ArrayList<>();
        for (int i = 0; i < letters.length - palindromeLength + 1; i++) {
            for (int j = i + palindromeLength - 1; j < letters.length; j++) {
                for(int g = 0; g < palindromeLength / 2; g++) {
                    if (letters[g + i] == letters[palindromeLength - g + i - 1]) {
                        isAPalindrome = true;
                    } else {
                        isAPalindrome = false;
                        break;
                    }
                }
                if (isAPalindrome == true) {
                    char[] palindromeLetters = Arrays.copyOfRange(letters, i, j + 1);
                        String palindromeWord = new String(palindromeLetters);
                        palindromeWords.add(palindromeWord);
                    }
                if (palindromeLength < letters.length) {
                    palindromeLength ++;
                }
            }
            palindromeLength = 3;
        }
        return palindromeWords;
    }
}
