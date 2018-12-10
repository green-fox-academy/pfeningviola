import reservationdatas.Reservation;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Reservation> reservations = new ArrayList<>();
    for(int i = 0; i < 5; i++) {
      reservations.add(new Reservation());
    }
    for(Reservation reservation : reservations) {
      System.out.println(reservation.toString());
    }
  }
}
