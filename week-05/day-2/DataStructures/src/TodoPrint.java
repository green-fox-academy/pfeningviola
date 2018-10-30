public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        String part1 = "My todo:\n";
        String part2 = " - Download games\n";
        String part3 = "\t - Diablo";
        String correctText = part1 + todoText + part2 + part3;
        System.out.println(correctText);
    }
}
