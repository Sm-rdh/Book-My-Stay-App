import java.util.HashMap;

/**
 * UseCase4RoomSearch
 * 
 * Demonstrates read-only room search using centralized inventory.
 * Only available rooms are displayed without modifying system state.
 * 
 * @author YourName
 * @version 4.0
 */

// Abstract Room class
abstract class Room {
    private int beds;
    private int size;
    private double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void displayDetails(String roomType, int availability) {
        System.out.println(roomType + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + price);
        System.out.println("Available: " + availability);
        System.out.println();
    }
}

// Room types
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

// Inventory (read-only usage here)
class RoomInventory {
    private HashMap<String, Integer> availabilityMap;

    public RoomInventory() {
        availabilityMap = new HashMap<>();
        availabilityMap.put("Single Room", 5);
        availabilityMap.put("Double Room", 3);
        availabilityMap.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return availabilityMap.getOrDefault(roomType, 0);
    }
}

// Search Service (NEW)
class RoomSearchService {

    public void searchAvailableRooms(Room[] rooms, RoomInventory inventory, String[] roomTypes) {

        System.out.println("Room Search\n");

        for (int i = 0; i < rooms.length; i++) {
            int available = inventory.getAvailability(roomTypes[i]);

            // Defensive check → only show available rooms
            if (available > 0) {
                rooms[i].displayDetails(roomTypes[i], available);
            }
        }
    }
}

// Main class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Room objects
        Room[] rooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new SuiteRoom()
        };

        String[] roomTypes = {
            "Single Room",
            "Double Room",
            "Suite Room"
        };

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Search service (read-only)
        RoomSearchService searchService = new RoomSearchService();
        searchService.searchAvailableRooms(rooms, inventory, roomTypes);
    }
}
