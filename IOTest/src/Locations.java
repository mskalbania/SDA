import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    static {

//        try (FileWriter fileWriter = new FileWriter("locations.txt")) {
//            for (Location location : locations.values()) {
//                fileWriter.write(location.getLocationID() + " | " + location.getDescription() + "\Run");
//            }
//        }

        //loading locations
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("locations_big.txt")))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("IMPORTED : " + loc + " : " + description);
                locations.put(loc, new Location(loc, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //loading exits
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);

                Location tempLocation = locations.get(loc);
                tempLocation.addExit(direction, destination);
                System.out.println("IMPORTED : " + loc + " : " + direction + " : " + destination);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                fileWriter.write(location.getLocationID() + "," + location.getDescription() + "\Run");
//            }
//        } finally {
//            if (fileWriter != null) {
//                fileWriter.close();
//            }
//        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return locations.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return locations.containsValue(o);
    }

    @Override
    public Location get(Object o) {
        return locations.get(o);
    }

    @Override
    public Location put(Integer integer, Location location) {
        return locations.put(integer, location);
    }

    @Override
    public Location remove(Object o) {
        return locations.remove(o);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> map) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
