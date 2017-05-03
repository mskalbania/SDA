import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Map<String, HeavenlyBody> solarSystem = new HashMap<>();
        Set<HeavenlyBody> planets = new HashSet<>();

        HeavenlyBody temp = new HeavenlyBody("Earth", 365);
        temp.addMoon(new HeavenlyBody("Moon", 10));
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Mars", 453);
        temp.addMoon(new HeavenlyBody("XX", 23));
        //added duplicate to debug
        temp.addMoon(new HeavenlyBody("XX", 23));
        temp.addMoon(new HeavenlyBody("ZZ", 44));
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        //adding duplicate working if(not)
        //OVERRIDE equals
        //OVERRIDE hashcode

        temp = new HeavenlyBody("Mars", 453);
        planets.add(temp);

        planets.add(new HeavenlyBody("Earth", 2323));

        System.out.println("All planets: ");
        for (HeavenlyBody planet : planets) {
            System.out.println(planet.getName() + " - " + planet.getPeriod());
        }
        System.out.println("All moons: ");
        //Merging sets into one
        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : planets) {
            moons.addAll(planet.getMoons());
        }
        //Showing all moons
        for (HeavenlyBody moon : moons) {
            System.out.println(moon.getName());
        }
        //Showing moons for Mars
        //Extracting Mars object from hash
        HeavenlyBody mars = solarSystem.get("Mars");
        System.out.println("Only for mars: ");
        for (HeavenlyBody marsMoons : mars.getMoons()) {
            System.out.println(marsMoons.getName());
        }


    }
}
