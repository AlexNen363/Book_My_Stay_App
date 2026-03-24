import java.util.*;

class BookingService {

    private BookingQueue bookingQueue;
    private RoomInventory inventory;
    private BookingHistory history; // ✅ NEW

    private Set<String> allocatedRoomIds;
    private HashMap<String, Set<String>> allocationMap;

    public BookingService(BookingQueue bookingQueue,
                          RoomInventory inventory,
                          BookingHistory history) {   // ✅ UPDATED

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.history = history;

        allocatedRoomIds = new HashSet<>();
        allocationMap = new HashMap<>();
    }

    public void processBookings() {

        System.out.println("\nProcessing Bookings...\n");

        while (!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.getNextRequest();

            String roomType = r.roomType;
            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                String roomId = generateRoomId(roomType);

                if (!allocatedRoomIds.contains(roomId)) {

                    allocatedRoomIds.add(roomId);

                    allocationMap.putIfAbsent(roomType, new HashSet<>());
                    allocationMap.get(roomType).add(roomId);

                    inventory.updateAvailability(roomType, available - 1);

                    // ✅ CONFIRM
                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + r.guestName);
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Room ID: " + roomId + "\n");

                    // ✅ UC8 ADD THIS LINE
                    history.addReservation(r);
                }

            } else {
                System.out.println("No rooms available for " + roomType + "\n");
            }
        }
    }

    private String generateRoomId(String roomType) {
        return roomType.substring(0, 2).toUpperCase()
                + "-" + (allocatedRoomIds.size() + 1);
    }
}