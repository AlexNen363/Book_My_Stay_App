public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App\n");

        // Booking Queue (UC5)
        BookingQueue bookingQueue = new BookingQueue();

        // Guest requests (arrival order)
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));

        // View queue (FIFO order)
        bookingQueue.viewRequests();
    }
}