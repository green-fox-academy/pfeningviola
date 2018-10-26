public class Colors {

    public static void main(String[] args) {
        String[][] colors = {{"lime", "forest green", "olive", "pale green", "spring green"}, {"orange red", "red", "tomato"}, {"orchid", "violet", "pink", "hot pink"}};
        for (String[] rows : colors) {
            for (String column : rows) {
                System.out.print(column + ", ");
            }
            System.out.println();
        }
    }
}
