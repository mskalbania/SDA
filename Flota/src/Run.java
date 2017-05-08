import java.util.Map;


public class Run {

    public static void main(String[] args) {

        Fleet myFleet = new Fleet("1st fleet");

        Car car1 = new Car("SBE09952", "Renault", 1000.0, 500);
        myFleet.addVehicle("SBE09952", car1);

        Truck truck1 = new Truck("SBE32456", "Man", 5000.0, 1000);
        myFleet.addVehicle("SBE32456", truck1);

        Bus bus1 = new Bus("SBE31236", "Ford", 4000.0, 3000);
        myFleet.addVehicle("SBE31236", bus1);


        //testing for duplicate / overwriting existing vehicle
        bus1 = new Bus("SBE31236", "TEST", 4000.0, 3000);
        myFleet.addVehicle("SBE31236", bus1);

        myFleet.getVehicle("SBE32456").setWeight(999.9);
        myFleet.getVehicle("SBE32456").setCourse(342.12);

        showVehicles(myFleet.getAllVehicleList());
    }

    public static void showVehicles(Map<String, Vehicle> list) {
        System.out.println("Available vehicles in fleet");
        System.out.println("TYPE | ID | BRAND | WEIGHT | COURSE | LOCATION\n");

        for (Map.Entry<String, Vehicle> vehicles : list.entrySet()) {
            System.out.println(vehicles.getValue().getVehicleType().toString() +
                    " | " + vehicles.getValue().getId() +
                    " | " + vehicles.getValue().getBrand() +
                    " | " + vehicles.getValue().getWeight() +
                    " | " + vehicles.getValue().getCourse() +
                    " | " + vehicles.getValue().getActualLocation());
        }
    }
}
