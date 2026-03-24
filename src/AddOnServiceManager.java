import java.util.*;

/**
 * Manages add-on services for reservations
 */
class AddOnServiceManager {

    // Map → Reservation ID to list of services
    private HashMap<String, List<Service>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to a reservation
    public void addService(String reservationId, Service service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);

        System.out.println("Service added to " + reservationId + ": " + service.name);
    }

    // Display services for a reservation
    public void displayServices(String reservationId) {

        List<Service> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services for " + reservationId);
            return;
        }

        System.out.println("\nServices for " + reservationId + ":");

        for (Service s : services) {
            s.display();
        }
    }

    // Calculate total cost
    public double calculateTotalCost(String reservationId) {

        List<Service> services = serviceMap.get(reservationId);
        double total = 0;

        if (services != null) {
            for (Service s : services) {
                total += s.price;
            }
        }

        return total;
    }
}