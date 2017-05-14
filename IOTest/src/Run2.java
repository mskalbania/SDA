import java.util.Map;

public class Run2 {
    public static void main(String[] args) {

        SavingReadingService srs = SavingReadingService.getInstance();

        for (Map.Entry<String, String> entry : srs.getSpots().entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
