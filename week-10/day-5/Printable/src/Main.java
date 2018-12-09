import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Domino> dominoes = new ArrayList<>();
    dominoes.add(new Domino(5, 2));
    dominoes.add(new Domino(4, 6));
    dominoes.add(new Domino(1, 5));
    dominoes.add(new Domino(6, 7));
    dominoes.add(new Domino(2, 4));
    dominoes.add(new Domino(7, 1));

    for (Domino d : dominoes) {
      d.printAllFields();
    }

    ArrayList<Todo> todos = new ArrayList<>();

    todos.add(new Todo("Get milk"));
    todos.add(new Todo("Remove the obstacles"));
    todos.add(new Todo("Stand up"));
    todos.add(new Todo("Eat lunch"));

    todos.get(2).complete();
    todos.get(3).complete();

    for (Todo t : todos) {
      t.printAllFields();
    }
  }
}
