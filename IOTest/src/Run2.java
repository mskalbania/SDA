import java.util.Map;

public class Run2 {
    public static void main(String[] args) {

        SavingReadingService srs = SavingReadingService.getInstance();
        srs.saveLocation("0000","0000");
        srs.reloadLocationsToMap();
        for (Map.Entry<String,String> entry : srs.getSpots().entrySet()){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
