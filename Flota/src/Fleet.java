import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Fleet {

    private final String name;
    private final Map<String, Vehicle> allVehicleList;

    public Fleet(String name) {
        this.name = name;
        this.allVehicleList = new HashMap<>();
    }

    public boolean addVehicle(String id, Vehicle vehicle) {

        Vehicle tempVehicle = allVehicleList.getOrDefault(id, null);

        if(tempVehicle == null && id.equals(vehicle.getId())){ //checking if ids are equal
            allVehicleList.put(id, vehicle);
            return true;
        }
        return false;
    }

    public Vehicle getVehicle(String id) {
        if (id != null) {
            return this.allVehicleList.get(id);
        }
        return null;
    }

    public Map<String, Vehicle> getAllVehicleList() {
        return Collections.unmodifiableMap(allVehicleList);
    }

    public Vehicle.GpsTracker getActualLocation(String id) {
        return this.allVehicleList.get(id).getActualLocation();
    }
}
