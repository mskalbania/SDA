import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double period;
    private final Set<HeavenlyBody> moons;

    HeavenlyBody(String name, double period){
        this.name = name;
        this.period = period;
        this.moons = new HashSet<>();
    }

    public String getName(){
        return this.name;
    }

    public double getPeriod(){
        return this.period;
    }

    public Set<HeavenlyBody> getMoons(){
        return new HashSet<>(this.moons);
    }

    public boolean addMoon(HeavenlyBody moon) {
        if (moon != null) {
            return this.moons.add(moon);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        //checking if objects classes match (not necessary in this case - class -> final)
        if(this.getClass() != obj.getClass()){
            return false;
        }
        return this.name.equals(((HeavenlyBody) obj).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
