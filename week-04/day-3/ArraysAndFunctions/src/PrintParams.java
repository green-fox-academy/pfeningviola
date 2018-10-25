public class PrintParams {

    public static void main(String[] args) {
        printParams("first", "second", "third", "forth", "fifth");
    }

    public static void printParams (String...parameters) {
        for (String a : parameters)
          System.out.print(a + " ");
    }
}
