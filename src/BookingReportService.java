import java.util.*;

/**
 * Generates reports from booking history
 */
class BookingReportService {

    public void generateReport(List<Reservation> history) {

        System.out.println("\nBooking Report:");

        HashMap<String, Integer> countMap = new HashMap<>();

        for (Reservation r : history) {
            countMap.put(r.roomType, countMap.getOrDefault(r.roomType, 0) + 1);
        }

        // Display summary
        for (String type : countMap.keySet()) {
            System.out.println(type + " booked: " + countMap.get(type));
        }
    }
}
