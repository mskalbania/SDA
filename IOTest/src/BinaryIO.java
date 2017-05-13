import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BinaryIO {

    private Map<String, String> randomList;

    public BinaryIO() {
        this.randomList = new HashMap<>();
    }

    public void fillMap(int amount) {

        for (int i = 0; i < amount; i++) {
            randomList.put(generateRandomWord(10), generateRandomWord(10));
        }
    }

    public Map<String, String> getRandomList() {
        return randomList;
    }

    private String generateRandomWord(int length) {
        String output = "";
        for (int i = 0; i < length; i++) {
            output += (char) (new Random().nextInt(25) + 65);
        }
        return output;
    }

    public void writeMapToExternalFile() throws IOException {
        try (DataOutputStream writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("output.dat")))) {
            for (Map.Entry<String, String> entry : randomList.entrySet()) {
                writer.writeUTF(entry.getKey());
                writer.writeUTF(entry.getValue());
            }
        }
    }

    public Map<String, String> readMapFromExternalFile() throws IOException {
        try (DataInputStream reader = new DataInputStream(new BufferedInputStream(new FileInputStream("output.dat")))) {
            Map<String, String> output = new HashMap<>();
            boolean eof = false;
            while (!eof) {
                try {
                    String key = reader.readUTF();
                    String value = reader.readUTF();
                    output.put(key, value);
                } catch (EOFException e) {
                    eof = true;
                }
            }
            return output;
        }
    }
}
