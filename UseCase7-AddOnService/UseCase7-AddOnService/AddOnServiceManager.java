import java.util.*;

public class AddOnServiceManager {

    private Map<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);
    }

    // Calculate total cost
    public double calculateTotalCost(String reservationId) {
        double total = 0.0;

        if (serviceMap.containsKey(reservationId)) {
            for (AddOnService service : serviceMap.get(reservationId)) {
                total += service.getCost();
            }
        }

        return total;
    }
}
