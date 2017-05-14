import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class SavingReadingService {

    private FileOutputStream outputStream = null;
    private FileInputStream inputStream = null;

    private Map<String, String> spots = new TreeMap<>();

    SavingReadingService() {
        try {
            inputStream = new FileInputStream("locations.dat");
            outputStream = new FileOutputStream("locations.dat", true);
        } catch (FileNotFoundException fnfe) {
            try {
                outputStream = new FileOutputStream("locations.dat");
                inputStream = new FileInputStream("locations.dat");
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        try {
            DataInputStream reader = new DataInputStream(new BufferedInputStream(inputStream));
            boolean eof = false;
            while (!eof) {
                try {
                    String id = reader.readUTF();
                    String description = reader.readUTF();
                    spots.put(id, description);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public boolean saveLocation(String id, String description) {
        if (!spots.containsKey(id)) {
            try {
                DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(outputStream));
                writer.writeUTF(id);
                writer.writeUTF(description);
                return true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return false;
    }

    public void closeAll(){
        try {
            outputStream.close();
            inputStream.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    public void deleteRecords() {
        try {
            outputStream = new FileOutputStream("locations.dat");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Map<String, String> getSpots() {
        return spots;
    }
}
