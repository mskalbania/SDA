package com.mothers;

import com.babies.Baby;

public class Mother {

    private String name;

    public Mother(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void serviceBaby(Baby baby) {

        System.out.println("com.babies.Baby serviced: " + baby.getName());
        baby.feed2(33, this);


    }
}
