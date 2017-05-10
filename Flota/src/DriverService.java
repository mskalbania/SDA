import java.util.*;

public class DriverService {

    private final Fleet fleet;
    private final Map<String, Driver> fleetDrivers;
    private static int driversCount = 0;

    public DriverService(Fleet fleet) {
        this.fleet = fleet;
        this.fleetDrivers = new TreeMap<>();
    }

    public boolean addDriver(String name, String surname) {
        if (name != null && surname != null) {

            String tempDriverId = String.format("%1$05d", driversCount);
            Driver tempDriver = new Driver(tempDriverId, name, surname);
            if (!fleetDrivers.containsValue(tempDriver)) {
                fleetDrivers.put(tempDriverId, tempDriver);
                driversCount++;
                return true;
            }
        }
        return false;
    }

    public boolean removeDrier(String workerId) {
        Driver tempDriver = fleetDrivers.getOrDefault(workerId, null);
        if(tempDriver != null){
            fleetDrivers.remove(workerId);
            return true;
        }
        return false;
    }

    public Map<String, Driver> getFleetDrivers() {
        return Collections.unmodifiableMap(fleetDrivers);
    }

    public Driver getDriver(String workerId) {
        if (fleetDrivers.containsKey(workerId)) {
            return new Driver(fleetDrivers.get(workerId));
        }
        return null;
    }

}
