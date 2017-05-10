import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Fleet {
    private final DriverService driverService = new DriverService(this);
    private final DispatchService dispatchService = new DispatchService(this);
    private final String name;
    private final Map<String, Vehicle> allVehicleList;

    public Fleet(String name) {
        this.name = name;
        this.allVehicleList = new HashMap<>();
    }

    public boolean addVehicle(String id, Vehicle vehicle) {

        Vehicle tempVehicle = allVehicleList.getOrDefault(id, null);

        if (tempVehicle == null && id.equals(vehicle.getId())) { //checking if ids are equal
            allVehicleList.put(id, vehicle);
            return true;
        }
        return false;
    }

    public boolean removeVehicle(String id) {

        Vehicle vehicleOnAllList = allVehicleList.getOrDefault(id, null);
        Vehicle vehicleOnDispatchedList = dispatchService.getDispatchedVehicles().getOrDefault(id, null);

        //checking if exist in fleet and not dispatched
        if (vehicleOnAllList != null && vehicleOnDispatchedList == null) {
            allVehicleList.remove(id);
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

    //dispatch service
    public boolean dispatchVehicle(String id) {
        return dispatchService.dispatchVehicle(id);
    }

    public boolean returnVehicle(String id) {
        return dispatchService.returnVehicle(id);
    }

    public Map<String, Vehicle> getDispatchedVehicles() {
        return dispatchService.getDispatchedVehicles();
    }
    //

    //driver service
    public boolean addDriver(String name, String surname) {
        return driverService.addDriver(name,surname);
    }

    public boolean removeDriver(String workerId){
        return driverService.removeDrier(workerId);
    }

    public Driver getDriver(String workerId){
        return driverService.getDriver(workerId);
    }

    public Map<String, Driver> getFleetDrivers(){
        return driverService.getFleetDrivers();
    }
    //

}


