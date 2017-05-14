import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SavingReadingService {

    private final static SavingReadingService savingReadingService = new SavingReadingService();

    private Map<String, String> spots;

    private SavingReadingService() {
        try {
            new FileOutputStream("locs.dat", true);
            reloadLocationsToMap();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Caused by FNFE");
        }
    }

    public static SavingReadingService getInstance() {
        return savingReadingService;
    }

    private DataInputStream openInputStream() {
        try {
            return new DataInputStream(new BufferedInputStream(new FileInputStream("locs.dat")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Caused by FNFE");
        }
    }

    private DataOutputStream openOutputStream() {
        try {
            return new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locs.dat", true)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Caused by FNFE");
        }
    }

    public boolean saveLocation(String id, String description) {
        if (!spots.containsKey(id)) {
            try (DataOutputStream writer = openOutputStream()) {
                writer.writeUTF(id);
                writer.writeUTF(description);
                spots.put(id,description);
                return true;
            } catch (IOException ioe) {
                throw new RuntimeException("Caused by IOE");
            }
        }
        return false;
    }

    //NOTE: remove location ~O(n) speed (not efficient cause of file being rewritten each time)
    //possible ways to fix it - Use Random Access Class (probably involves rebuilding entire class)
    public void removeLocation(String id) {
        Map<String, String> tempMap = new TreeMap<>(spots);
        tempMap.remove(id);
        clearAll();
        spots = tempMap;
        try (DataOutputStream writer = openOutputStream()) {
            for (Map.Entry<String, String> entry : spots.entrySet()) {
                writer.writeUTF(entry.getKey());
                writer.writeUTF(entry.getValue());
            }
        } catch (IOException ioe) {
            throw new RuntimeException("Caused by IOE");
        }
    }

    public void clearAll() {
        try {
            new FileOutputStream("locs.dat");
            spots = new TreeMap<>();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Caused by FNFE");
        }
    }

    public void reloadLocationsToMap() {
        try (DataInputStream reader = openInputStream()) {
            boolean eof = false;
            spots = new TreeMap<>();
            while (!eof) {
                try {
                    String id = reader.readUTF();
                    String description = reader.readUTF();
                    spots.put(id, description);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Caused by IOE");
        }
    }

    public Map<String, String> getSpots() {
        return spots;
    }
}
