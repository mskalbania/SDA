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

        //testing setters
        myFleet.getVehicle("SBE32456").setWeight(999.9);
        myFleet.getVehicle("SBE32456").setCourse(342.12);

        showVehicles(myFleet.getAllVehicleList(), "ALL");

        //testing remove

        myFleet.removeVehicle("SBE32456");
        showVehicles(myFleet.getAllVehicleList(), "ALL (after remove)");

        //testing dispatcher service
        myFleet.dispatchVehicle("SBE09952");
        myFleet.dispatchVehicle("SBE31236");
        //already dispatched
        System.out.println("already: " + myFleet.dispatchVehicle("SBE09952"));
        //wrong id
        System.out.println("wrong id: " + myFleet.dispatchVehicle("KRA09952"));

        showVehicles(myFleet.getDispatchedVehicles(), "DISPATCHED");

        //returning
        myFleet.returnVehicle("SBE09952");
        //not dispatched
        myFleet.returnVehicle("SBE32456");

        showVehicles(myFleet.getDispatchedVehicles(), "DISPATCHED");


        //testing driver service
        myFleet.addDriver("Mateusz", "Skalbania");
        myFleet.addDriver("Tim", "Tim");
        myFleet.addDriver("Tim", "BB");
        myFleet.addDriver("Tim", "CC");

        showDrivers(myFleet.getFleetDrivers());

        //testing for duplicate
        System.out.println("\nSAME NAME , SURNAME : " + myFleet.addDriver("Mateusz", "Skalbania"));

        //getting driver
        System.out.println(myFleet.getDriver("00001"));
        System.out.println(myFleet.getDriver("00005")); //should return null if not found

        //removing driver
        myFleet.removeDriver("00002");
        myFleet.removeDriver("00005");
        showDrivers(myFleet.getFleetDrivers());

    }

    public static void showVehicles(Map<String, Vehicle> list, String title) {
        System.out.println();
        System.out.println(title);
        System.out.println("TYPE | ID | BRAND | WEIGHT | COURSE | LOCATION");

        for (Map.Entry<String, Vehicle> vehicles : list.entrySet()) {
            System.out.println(vehicles.getValue().getVehicleType().toString() +
                    " | " + vehicles.getValue().getId() +
                    " | " + vehicles.getValue().getBrand() +
                    " | " + vehicles.getValue().getWeight() +
                    " | " + vehicles.getValue().getCourse() +
                    " | " + vehicles.getValue().getActualLocation());
        }
    }

    public static void showDrivers(Map<String, Driver> list) {
        System.out.println();
        System.out.println("WORKER ID | NAME | SURNAME");
        for (Map.Entry<String, Driver> drivers : list.entrySet()) {
            System.out.println(drivers.getValue().getWorkerId() +
                    " | " + drivers.getValue().getName() +
                    " | " + drivers.getValue().getSurname());
        }
    }
}
