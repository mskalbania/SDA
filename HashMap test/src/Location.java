import java.util.HashMap;
import java.util.Map;

class Location {

    private final int id;
    private final String description;
    private final Map<String, Integer> exits;

    Location(int id, String description) {
        this.id = id;
        this.description = description;
        exits = new HashMap<>();
        exits.put("EXIT", 0);
    }

    void addExit(String direction, int locationDestination) {
        this.exits.put(direction, locationDestination);
    }

    int getId() {
        return this.id;
    }

    String getDescription() {
        return this.description;
    }

    Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }


}
