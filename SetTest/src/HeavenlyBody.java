import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final String name;
    private final double period;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    public enum BodyTypes {
        PLANET,
        STAR,
        ASTEROID,
        MOON,
    }


    HeavenlyBody(String name, double period, BodyTypes bodyType){
        this.name = name;
        this.period = period;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    String getName(){
        return this.name;
    }

    double getPeriod(){
        return this.period;
    }

    Set<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    boolean addSatellite(HeavenlyBody moon) {
        if (moon != null) {
            return this.satellites.add(moon);
        }
        return false;
    }

    @Override
    public final boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof HeavenlyBody){
            HeavenlyBody temporary = (HeavenlyBody) obj;
            if(this.name.equals(temporary.getName())){
                return this.bodyType == temporary.getBodyType();
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.name + ", Type: " + this.bodyType + ", Period: " + this.period;
    }
}
