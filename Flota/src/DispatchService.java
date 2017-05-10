import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DispatchService {

    private final Fleet fleet;
    private final Map<String, Vehicle> dispatchedVehicles;

    DispatchService(Fleet fleet) {
        this.fleet = fleet;
        this.dispatchedVehicles = new HashMap<>();
    }

    public boolean dispatchVehicle(String id) {
        Vehicle vehicleFromFleet = fleet.getAllVehicleList().getOrDefault(id, null); //checking if exist in fleet
        Vehicle vehicleDispatched = dispatchedVehicles.getOrDefault(id, null); // checking if vehicle already dispatched

        if (id != null && vehicleFromFleet != null && vehicleDispatched == null) {
            dispatchedVehicles.put(id, vehicleFromFleet);
            return true;
        }
        return false;
    }

    public boolean returnVehicle(String id) {
        Vehicle temp = dispatchedVehicles.getOrDefault(id, null);
        if (temp != null) {
            dispatchedVehicles.remove(id);
            return true;
        }
        return false;
    }

    public Map<String, Vehicle> getDispatchedVehicles() {
        return Collections.unmodifiableMap(dispatchedVehicles);
    }
}
