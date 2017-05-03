public class Planet extends HeavenlyBody {

    Planet(String name, double period) {
        super(name, period, BodyTypes.PLANET);
    }

    @Override
    boolean addSatellite(HeavenlyBody moon) {
        if (moon.getBodyType() == BodyTypes.MOON) {
            return super.addSatellite(moon);
        } else return false;
    }

}
