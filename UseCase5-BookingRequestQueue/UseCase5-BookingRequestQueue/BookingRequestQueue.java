import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.add(reservation);
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }

    public Reservation processNextRequest() {
        return requestQueue.poll();
    }
}
