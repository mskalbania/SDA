import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JavaNIO  extends BinaryIO{

    Path outputPath = FileSystems.getDefault().getPath("output.dat");

    @Override
    public void writeMapToExternalFile() throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter(outputPath)){
            for(Map.Entry<String ,String> entry : super.getRandomList().entrySet()){
                System.out.println("Writing: " + entry.getKey() + " -> " + entry.getValue());
                long start = System.nanoTime();
                writer.write(entry.getKey());
                writer.write(entry.getValue());
                System.out.println(">>>>" + (System.nanoTime() - start) + " nano seconds.");

            }
        }
    }
}
