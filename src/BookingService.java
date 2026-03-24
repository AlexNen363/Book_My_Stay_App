import java.util.*;

class BookingService {

    private BookingQueue bookingQueue;
    private RoomInventory inventory;

    // Track allocated room IDs (no duplicates)
    private Set<String> allocatedRoomIds;

    // Map room type → allocated room IDs
    private HashMap<String, Set<String>> allocationMap;

    public BookingService(BookingQueue bookingQueue, RoomInventory inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;

        allocatedRoomIds = new HashSet<>();
        allocationMap = new HashMap<>();
    }

    // Process bookings (FIFO)
    public void processBookings() {

        System.out.println("\nProcessing Bookings...\n");

        while (!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.getNextRequest(); // dequeue

            String roomType = r.roomType;

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Prevent duplicate
                if (!allocatedRoomIds.contains(roomId)) {

                    allocatedRoomIds.add(roomId);

                    // Map allocation
                    allocationMap.putIfAbsent(roomType, new HashSet<>());
                    allocationMap.get(roomType).add(roomId);

                    // Update inventory
                    inventory.updateAvailability(roomType, available - 1);

                    // Confirm booking
                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + r.guestName);
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Room ID: " + roomId + "\n");

                }

            } else {
                System.out.println("No rooms available for " + roomType + "\n");
            }
        }
    }

    // Generate unique room ID
    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase() + "-" + (allocatedRoomIds.size() + 1);
    }
}