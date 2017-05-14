import java.util.Map;

public class Run2 {
    public static void main(String[] args) {
        SavingReadingService srs = new SavingReadingService();

        srs.saveLocation("1","1");
        srs.saveLocation("2","2");
        srs.closeAll();

        for (Map.Entry<String,String> entry : srs.getSpots().entrySet()){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
