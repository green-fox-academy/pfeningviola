import java.util.ArrayList;

public class Candyshop {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("Cupcake");
        arrayList.add(2);
        arrayList.add("Brownie");
        arrayList.add(false);
        System.out.println(sweets(arrayList));
    }

    public static ArrayList<String> sweets(ArrayList list) {
        list.set(list.indexOf(2), "Croissant");
        list.set(list.indexOf(false), "Ice cream");
        return list;
    }
}
