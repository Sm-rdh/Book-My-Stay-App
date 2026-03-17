import java.util.*;

public class InventoryService {

    private Map<String, Integer> roomInventory;
    private Map<String, Set<String>> allocatedRooms;

    public InventoryService() {
        roomInventory = new HashMap<>();
        allocatedRooms = new HashMap<>();

        roomInventory.put("Single", 2);
        roomInventory.put("Double", 2);
        roomInventory.put("Suite", 1);

        allocatedRooms.put("Single", new HashSet<>());
        allocatedRooms.put("Double", new HashSet<>());
        allocatedRooms.put("Suite", new HashSet<>());
    }

    public String allocateRoom(String roomType) {

        if (roomInventory.get(roomType) <= 0) {
            return null;
        }

        int roomNumber = allocatedRooms.get(roomType).size() + 1;
        String roomId = roomType + "-" + roomNumber;

        if (allocatedRooms.get(roomType).contains(roomId)) {
            return null;
        }

        allocatedRooms.get(roomType).add(roomId);
        roomInventory.put(roomType, roomInventory.get(roomType) - 1);

        return roomId;
    }
}
