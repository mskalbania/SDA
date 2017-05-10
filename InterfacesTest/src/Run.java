import animals.Dog;
import interfaces.Audible;

public class Run {

    public static void main(String[] args) {

        Zoo zoo = new Zoo();
        zoo.addAnimals();
        zoo.runAnimalByObjectReference();
        System.out.println();
        zoo.runAnimalByInterfaceReference();
        System.out.println();
        zoo.walkAnimalByInterfaceReference();
        System.out.println();
        zoo.makeNoiseByInterfaceReference();
        System.out.println("\n");

        Audible audible = zoo.getAudibles().get(0); //having only 1 method
        ((Dog) audible).run(); //having 3 methods
    }
}
