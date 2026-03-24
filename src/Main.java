public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Booking Queue
        BookingQueue bookingQueue = new BookingQueue();

        // Add requests
        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));
        bookingQueue.addRequest(new Reservation("David", "Single Room"));

        // Booking Service
        BookingService bookingService = new BookingService(bookingQueue, inventory);

        // Process bookings
        bookingService.processBookings();
    }
}