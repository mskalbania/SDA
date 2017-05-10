import animals.Dog;
import animals.Elephant;
import animals.Snake;
import interfaces.Audible;
import interfaces.Movable;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Dog> dogs;
    private List<Elephant> elephants;
    private List<Snake> snakes;

    private List<Movable> movables;
    private List<Audible> audibles;


    public Zoo() {
        this.dogs = new ArrayList<>();
        this.elephants = new ArrayList<>();
        this.snakes = new ArrayList<>();

        this.movables = new ArrayList<>();
        this.audibles = new ArrayList<>();
    }

    public void addAnimals() {
        Dog dog = new Dog();
        Snake snake = new Snake();
        Elephant elephant = new Elephant();

        dogs.add(dog);
        elephants.add(elephant);
        snakes.add(snake);
        //adding to movables
        movables.add(dog);
        movables.add(snake);
        movables.add(elephant);
        //adding to audibles
        audibles.add(dog);
        audibles.add(snake);
        audibles.add(elephant);
    }

    public List<Movable> getMovables() {
        return movables;
    }

    public void setMovables(List<Movable> movables) {
        this.movables = movables;
    }

    public List<Audible> getAudibles() {
        return audibles;
    }

    public void setAudibles(List<Audible> audibles) {
        this.audibles = audibles;
    }

    public void runAnimalByObjectReference() {

        for (Dog dog : dogs) {
            dog.run();
        }

        for (Elephant elephant : elephants) {
            elephant.run();
        }

        for (Snake snake : snakes) {
            snake.run();
        }
    }

    public void runAnimalByInterfaceReference() {
        for (Movable movable : movables) {
            movable.run();
        }
    }

    public void walkAnimalByInterfaceReference() {
        for (Movable movable : movables) {
            movable.hide();
        }
    }

    public void makeNoiseByInterfaceReference() {
        for (Audible audible : audibles) {
            audible.makeNoise();
        }
    }
}
