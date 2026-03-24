public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App\n");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Queue
        BookingQueue bookingQueue = new BookingQueue();

        bookingQueue.addRequest(new Reservation("Alice", "Single Room"));
        bookingQueue.addRequest(new Reservation("Bob", "Double Room"));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite Room"));

        // UC8 History
        BookingHistory history = new BookingHistory();

        // Booking Service
        BookingService bookingService =
                new BookingService(bookingQueue, inventory, history);

        bookingService.processBookings();

        // Show History
        history.displayHistory();

        // Report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history.getHistory());
    }
}