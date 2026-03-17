import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<String, Integer> inventory = new HashMap<>();
    private Map<String, Integer> counters = new HashMap<>();

    public InventoryService() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        counters.put("Single", 0);
        counters.put("Double", 0);
        counters.put("Suite", 0);
    }

    // synchronized critical section
    public synchronized String allocateRoom(String roomType) {

        if (inventory.get(roomType) <= 0) {
            return null;
        }

        inventory.put(roomType, inventory.get(roomType) - 1);

        int count = counters.get(roomType) + 1;
        counters.put(roomType, count);

        return roomType + "-" + count;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}
