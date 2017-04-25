package com.oop1;

class Car {
    private String model;
    private double engineSize;
    private String colour;

    Car(String model, double engineSize, String colour) {
        this.model = model;
        this.engineSize = engineSize;
        this.colour = colour;

    }

    String getModel() {
        return model;
    }

    double getEngineSize() {
        return engineSize;
    }

    String getColour() {
        return colour;
    }


}
