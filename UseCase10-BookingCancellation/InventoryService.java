import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<String, Integer> inventory;

    public InventoryService() {
        inventory = new HashMap<>();
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);
    }

    public boolean allocateRoom(String roomType) {
        if (inventory.get(roomType) > 0) {
            inventory.put(roomType, inventory.get(roomType) - 1);
            return true;
        }
        return false;
    }

    public void releaseRoom(String roomType) {
        inventory.put(roomType, inventory.get(roomType) + 1);
    }

    public int getAvailability(String roomType) {
        return inventory.get(roomType);
    }
}
