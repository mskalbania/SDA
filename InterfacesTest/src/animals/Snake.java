package animals;

import interfaces.Audible;
import interfaces.Movable;

public class Snake implements Movable, Audible {

    @Override
    public void hide() {
        System.out.println(this.getClass().getSimpleName() + " is hiding");
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " is running");
    }


    @Override
    public void makeNoise() {
        System.out.println(this.getClass().getSimpleName() + " is making noise");
    }
}
