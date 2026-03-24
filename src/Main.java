public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v1.0\n");

        // Room objects (same as UC2)
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display room details
        r1.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Single Room") + "\n");

        r2.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Double Room") + "\n");

        r3.displayDetails();
        System.out.println("Available: " + inventory.getAvailability("Suite Room") + "\n");

        // Display full inventory
        inventory.displayInventory();
    }
}