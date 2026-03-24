public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v1.0\n");

        // Room objects
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        Room[] rooms = {r1, r2, r3};

        // Inventory (UC3)
        RoomInventory inventory = new RoomInventory();

        // Search Service (UC4)
        RoomSearchService searchService = new RoomSearchService(inventory);

        // Perform search (READ ONLY)
        searchService.searchAvailableRooms(rooms);
    }
}