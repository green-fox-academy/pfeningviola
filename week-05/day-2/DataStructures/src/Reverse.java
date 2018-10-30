public class Reverse {
    public static void main(String[] args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        System.out.println(reverse(reversed));
        System.out.println(reverse2(reversed));
    }

    //With charAt
    public static String reverse(String text){
        String correctText = new String();
        for (int i = 0; i < text.length(); i++) {
            correctText = correctText + text.charAt(text.length() - i - 1);
        }
        return correctText;
    }
    
    //With char[]
    public static String reverse2(String text){
        char[] reversedLetters = text.toCharArray();
        char[] correctLetters = new char[reversedLetters.length];
        for (int i = 0; i < reversedLetters.length; i++) {
            System.arraycopy(reversedLetters, (reversedLetters.length - 1 - i), correctLetters, i, 1);
        }
        String correct = new String(correctLetters);
        return correct;
    }
}
