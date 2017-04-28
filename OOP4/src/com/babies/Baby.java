package com.babies;

import com.mothers.Mother;

public class Baby {

    private String name;
    private int servings;
    private Mother mother;

    public Baby(String name, Mother mother) {
        this.name = name;
        this.mother = mother;
    }

    public void feed(int servings) {
        this.mother.serviceBaby(this);

    }

    public void feed2(int servings, Mother fromMother) {
        System.out.printf(fromMother.getName() + "serviced babies.");
        this.servings += servings;

    }

    void poop() {
        System.out.printf("All better!");
        servings = 0;
    }

    public String getName() {
        return name;
    }


}
