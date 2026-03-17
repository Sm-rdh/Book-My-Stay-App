import java.util.List;

public class RoomSearchService {

    public void searchAvailableRooms(List<Room> rooms, RoomInventory inventory) {

        System.out.println("Room Search\n");

        for (Room room : rooms) {
            int available = inventory.getAvailability(room.getRoomType());

            // Show only available rooms
            if (available > 0) {
                room.displayDetails(available);
            }
        }
    }
}
