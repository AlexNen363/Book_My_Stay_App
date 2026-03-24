import java.util.LinkedList;
import java.util.Queue;

class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation r) {
        queue.add(r);
        System.out.println("Request added:");
        r.display();
    }

    // View all requests
    public void viewRequests() {
        System.out.println("\nBooking Queue:");
        for (Reservation r : queue) {
            r.display();
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Reservation getNextRequest() {
        return queue.poll(); // FIFO
    }
}