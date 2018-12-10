package reservationdatas;

public class Reservation implements Reservationy {
  private String bookingCode;
  private String bookingDow;

  public Reservation() {
    this.bookingCode = getCodeBooking();
    this.bookingDow = getDowBooking();
  }

  @Override
  public String getCodeBooking() {
    char[] options = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'J', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    String bookingCode = "";
    for (int i = 0; i < 8; i++) {
      int indexOfRandomChar = (int)(Math.random() * options.length);
      bookingCode += options[indexOfRandomChar];
    }
    return bookingCode;
  }

  @Override
  public String getDowBooking() {
    String[] days = {"MON", "THU", "WED", "THU", "FRI", "SAT", "SUN"};
    int indexOfRandomDay = (int)(Math.random() * 7);
    return days[indexOfRandomDay];
  }

  @Override
  public String toString() {
    return String.format("Booking# %s for %s", bookingCode, bookingDow);
  }
}
