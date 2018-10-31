import java.util.ArrayList;
import java.util.Arrays;

public class ElementFinder {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        containsSeven(arrayList);
        containsSeven2(arrayList);
    }

    public static void containsSeven(ArrayList<Integer> numbers){
        if(numbers.contains(7)) {
            System.out.println("Hoorray");
        } else {
            System.out.println("Noooooo");
        }
        return;
    }

    public static void containsSeven2(ArrayList<Integer> numbers) {
        boolean answer = false;
        for(int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 7) {
                answer = true;
                System.out.println("Hoorray");
                break;
            } else {
                answer = false;
            }
        }
        if (answer == false) {
            System.out.println("Noooooo");
        }
        return;
    }
}

