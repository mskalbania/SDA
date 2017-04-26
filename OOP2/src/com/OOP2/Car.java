package com.OOP2;

class Car {

    private int wheelCount;
    private String brand;


    Car() {
    }

    Car(int wheelCount) {
        this.wheelCount = wheelCount;
    }

    Car(String brand) {
        this.brand = brand;
    }

    Car(int wheelCount, String brand) {
        this.wheelCount = wheelCount;
        this.brand = brand;
    }

    void doBlink() {

        System.out.println("Car blinked");

    }

    public int getWheelCount() {
        return wheelCount;
    }

    public String getBrand() {
        return brand;
    }

}
