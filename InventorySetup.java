import java.util.HashMap;

/**
 * UseCase3InventorySetup
 * 
 * Demonstrates centralized inventory management using HashMap.
 * 
 * @author YourName
 * @version 3.1
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
        System.out.println("Available Rooms: " + availability);
        System.out.println();
    }
}

// Room Types
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

// Inventory Class (NEW)
class RoomInventory {
    private HashMap<String, Integer> availabilityMap;

    // Constructor initializes inventory
    public RoomInventory() {
        availabilityMap = new HashMap<>();
        availabilityMap.put("Single Room", 5);
        availabilityMap.put("Double Room", 3);
        availabilityMap.put("Suite Room", 2);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return availabilityMap.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        availabilityMap.put(roomType, count);
    }
}

// Main class
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        // Create rooms
        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display details using centralized data
        single.displayDetails("Single Room", inventory.getAvailability("Single Room"));
        doub.displayDetails("Double Room", inventory.getAvailability("Double Room"));
        suite.displayDetails("Suite Room", inventory.getAvailability("Suite Room"));
    }
}
