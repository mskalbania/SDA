package com.oop1;

/*
Random cars (objects) generating and adding them to list (garage)
 */

public class Run {

    public static void main(String[] args) {

        final String[] carManufacturers = {"Ferrari", "Audi", "Porsche", "Toyota",
                                            "Fiat", "BMW", "Mercedes"};
        final double[] carEngineSizes = {1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0};

        final String[] carColours = {"red", "white", "black", "yellow", "orange"};

        final int numberOfCarsAdded = 5;

        Garage garage1 = new Garage();

        for (int i = 0; i < numberOfCarsAdded ; i++) {
            garage1.addCarToGarage(carManufacturers[(int)(Math.random()*7)],
                                    carEngineSizes[(int)(Math.random()*7)],
                                    carColours[(int)(Math.random()*5)]);
        }

        garage1.showListOfCars();
    }




}
