import java.io.IOException;
import java.util.Map;

public class Run {

    public static void main(String[] args) {

        BinaryIO binaryIO = new BinaryIO();
        //binaryIO.fillMap(100);
        //show(binaryIO.getRandomList());

        try {
           // binaryIO.writeMapToExternalFile();
            show(binaryIO.readMapFromExternalFile());

        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void show(Map<String ,String> input){
        for(Map.Entry<String ,String> map : input.entrySet()){
            System.out.println(map.getKey() + " - > " + map.getValue());
        }
    }
}
