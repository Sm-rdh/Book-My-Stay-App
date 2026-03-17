public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        BookingRequestQueue queue = new BookingRequestQueue();
        InventoryService inventory = new InventoryService();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vannathi", "Suite"));

        while (queue.hasPendingRequests()) {
            Reservation r = queue.processNextRequest();

            String roomId = inventory.allocateRoom(r.getRoomType());

            if (roomId != null) {
                System.out.println("Booking confirmed for Guest: "
                        + r.getGuestName()
                        + ", Room ID: "
                        + roomId);
            } else {
                System.out.println("Booking failed for Guest: "
                        + r.getGuestName()
                        + " (No rooms available)");
            }
        }
    }
}
