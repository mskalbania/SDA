import java.util.*;


public class SetTest {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        HeavenlyBody temp = new Planet("Mercury", 250);
        temp.addSatellite(new Moon("MercuryMoon1", 22));
        temp.addSatellite(new Moon("MercuryMoon2", 22));
        temp.addSatellite(new Moon("MercuryMoon3", 22));
        planets.add(temp);
        solarSystem.put(temp.getName(), temp);

        temp = new Planet("Earth", 365);
        temp.addSatellite(new Moon("Moon", 10));
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new Planet("Mars", 2520);
        temp.addSatellite(new Moon("MarsMoon1", 22));
        temp.addSatellite(new Moon("MarsMoon2", 22));
        temp.addSatellite(new Moon("MarsMoon3", 22));
        planets.add(temp);
        solarSystem.put(temp.getName(), temp);

        temp = new Planet("Venus", 250);
        temp.addSatellite(new Moon("VenusMoon1", 52));
        temp.addSatellite(new Moon("VenusMoon2", 32));
        temp.addSatellite(new Moon("VenusMoon3", 22));
        planets.add(temp);
        solarSystem.put(temp.getName(), temp);
        temp = new Star("Venus", 634);
        planets.add(temp);
        solarSystem.put(temp.getName(),temp);

        System.out.println("Planets: ");
        for(HeavenlyBody planet:planets){
            System.out.println(planet);
        }
        System.out.println("------------------");

        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet: planets){
            moons.addAll(planet.getSatellites());
        }
        System.out.println("Moons: ");
        for (HeavenlyBody moon: moons){
            System.out.println(moon);
        }
        System.out.println("------------------");


        HeavenlyBody check1 = new Planet("Earth", 11);
        HeavenlyBody check2 = new Planet("Earth", 23);
        System.out.println(check1.equals(check2));
        System.out.println(check2.equals(check1));


        
//        temp = new HeavenlyBody("Mars", 453);
//        temp.addSatellite(new HeavenlyBody("XX", 23));
//        //added duplicate to debug
//        temp.addSatellite(new HeavenlyBody("XX", 23));
//        temp.addSatellite(new HeavenlyBody("ZZ", 44));
//        solarSystem.put(temp.getName(), temp);
//        planets.add(temp);
//
//        //adding duplicate working if(not)
//        //OVERRIDE equals
//        //OVERRIDE hashcode
//
//        temp = new HeavenlyBody("Mars", 453);
//        planets.add(temp);
//
//        planets.add(new HeavenlyBody("Earth", 2323));
//
//        System.out.println("All planets: ");
//        for (HeavenlyBody planet : planets) {
//            System.out.println(planet.getName() + " - " + planet.getPeriod());
//        }
//        System.out.println("All moons: ");
//        //Merging sets into one
//        Set<HeavenlyBody> moons = new HashSet<>();
//        for (HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites());
//        }
//        //Showing all moons
//        for (HeavenlyBody moon : moons) {
//            System.out.println(moon.getName());
//        }
//        //Showing moons for Mars
//        //Extracting Mars object from hash
//        HeavenlyBody mars = solarSystem.get("Mars");
//        System.out.println("Only for mars: ");
//        for (HeavenlyBody marsMoons : mars.getSatellites()) {
//            System.out.println(marsMoons.getName());
//        }


    }
}
