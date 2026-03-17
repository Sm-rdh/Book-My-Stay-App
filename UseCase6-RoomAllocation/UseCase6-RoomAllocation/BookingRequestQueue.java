import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> requestQueue = new LinkedList<>();

    public void addRequest(Reservation r) {
        requestQueue.add(r);
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }

    public Reservation processNextRequest() {
        return requestQueue.poll();
    }
}
