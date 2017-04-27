package com.OOP2;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        Car car1 = new Car(4);
        Car car2 = new Car("Skoda");
        Car car3 = new Car(6, "Jeep");

        car.doBlink();
        car2.doBlink();
        car1.doBlink();
        car3.doBlink();

        car.set("Audi");
        car.set(4);

        car1.set("Fiat");

        car2.set(6);

        System.out.println(car3.getBrand() + " -----> " + car3.getWheelCount());
        System.out.println(car1.getBrand() + " -----> " + car1.getWheelCount());
        System.out.println(car.getBrand() + " -----> " + car.getWheelCount());
        System.out.println(car2.getBrand() + " -----> " + car2.getWheelCount());

        System.out.println("--------------------------------");

        System.out.println(car == car1); //compare references
        System.out.println(car1.equals(car)); //compare objects

        car1 = car;

        System.out.println(car == car1); //compare references
        System.out.println(car.equals(car1)); //compare objects



    }

}
