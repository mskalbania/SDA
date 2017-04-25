package com.oop1;

public class Run {

    public static void main(String[] args) {

        Garage garage1 = new Garage();

        garage1.addCarToGarage("Ferrari", 4.0, "red");
        garage1.addCarToGarage("Porsche", 3.0, "yellow");
        garage1.addCarToGarage("Audi", 2.0, "grey");

        garage1.showListOfCars();
    }


}
