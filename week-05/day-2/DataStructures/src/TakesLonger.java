public class TakesLonger {
    public static void main(String[] args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
        int indexIt = quote.indexOf("It");
        int indexYou = quote.indexOf("you");
        String correctQuote = quote.substring(0, (indexIt + 3)) + "always takes longer than " + quote.substring(indexYou);

        System.out.println(correctQuote);

    }
}
