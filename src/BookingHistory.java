import java.util.*;

/**
 * Stores confirmed bookings in order
 */
class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed booking
    public void addReservation(Reservation r) {
        history.add(r);
    }

    // Get all bookings
    public List<Reservation> getHistory() {
        return history;
    }

    // Display history
    public void displayHistory() {
        System.out.println("\nBooking History:");

        for (Reservation r : history) {
            r.display();
        }
    }
}