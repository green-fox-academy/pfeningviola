public class AppendA {

    public static void main(String[] args) {
        String typo = "Chinchill";
        System.out.println(appendAFunc(typo));
    }

    public static String appendAFunc (String basicWord) {
        String newWord = basicWord + "a";
        return newWord;
    }
}
