import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner operation = new Scanner(System.in);
        System.out.println("Please type in the expression: ");
        String expression = operation.nextLine();
        System.out.println("Result: " + calculate(expression));
    }

    public static double calculate(String input){
        double result = 0;
        String[] arrayParts = input.split(" ");
        ArrayList<String> expressionParts = new ArrayList<>();
        expressionParts.addAll(Arrays.asList(arrayParts));
        double operand1 = Double.parseDouble(expressionParts.get(1));
        double operand2 = Double.parseDouble(expressionParts.get(2));
        if (expressionParts.get(0).equals("+")){
            result = operand1 + operand2;
        } else if (expressionParts.get(0).equals("-")) {
            result = operand1 - operand2;
        } else if (expressionParts.get(0).equals("*")) {
            result = operand1 * operand2;
        } else if (expressionParts.get(0).equals("/")) {
            result = operand1 / operand2;
        } else if (expressionParts.get(0).equals("%")) {
            result = operand1 % operand2;
        }
        return result;
    }
}
