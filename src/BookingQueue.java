import java.util.LinkedList;
import java.util.Queue;

class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add request (enqueue)
    public void addRequest(Reservation r) {
        queue.add(r);
        System.out.println("Request added:");
        r.display();
    }

    // View all requests (without removing)
    public void viewRequests() {
        System.out.println("\nBooking Queue:");

        for (Reservation r : queue) {
            r.display();
        }
    }
}