package com.oop1;

import java.util.ArrayList;

class Garage {

    private ArrayList<Car> carArrayList = new ArrayList<>();

    void addCarToGarage(String model, double engineSize, String colour) {

        Car car = new Car(model, engineSize, colour);
        this.carArrayList.add(car);

    }

    void showListOfCars() {
        for (int i = 0; i < this.carArrayList.size(); i++) {
            System.out.println((i + 1) + "#  Model: " + this.carArrayList.get(i).getModel() +
                    " | Engine size: " + this.carArrayList.get(i).getEngineSize() +
                    " | Colour: " + this.carArrayList.get(i).getColour() + " | ");
            System.out.println("----------------------------------------------------------------");
        }
    }
}