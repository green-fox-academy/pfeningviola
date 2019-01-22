import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExercisesFirst5 {

  public static void main(String[] args) {

    //Exercise 1.
    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    List<Integer> evenNumbers = numbers.stream()
        .filter(number -> number % 2 == 0)
        .collect(Collectors.toList());
    System.out.println(evenNumbers);


    // Exercise 2.
    List<Integer> squareOfPositiveNumbers = numbers.stream()
        .filter(number -> number > 0)
        .map(number -> number * number)
        .collect(Collectors.toList());
    System.out.println(squareOfPositiveNumbers);


    //Exercise 3.
    List<Integer> numbers2 = Arrays.asList(3, 9, 2, 8, 6, 5);
    List<Integer> squareMoreThan20 = numbers2.stream()
        .filter(number -> number * number > 20)
        .collect(Collectors.toList());
    System.out.println(squareMoreThan20);


    //Exercise 4.
    IntSummaryStatistics statsOddNumbers = numbers.stream()
        .filter(number -> number % 2 != 0)
        .mapToInt(x -> x)
        .summaryStatistics();
    double averageOfOddNumbers = statsOddNumbers.getAverage();
    System.out.println("Average of the odd numbers: " + averageOfOddNumbers);


    //Exercise 5.
    List<Integer> numbers3 = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);
    IntSummaryStatistics statsOddNumbers2 = numbers3.stream()
        .filter(number -> number % 2 != 0)
        .mapToInt(x -> x)
        .summaryStatistics();
    double sumOfOddNumbers = statsOddNumbers2.getSum();
    System.out.println("Sum of the odd numbers: " + sumOfOddNumbers);
  }
}
