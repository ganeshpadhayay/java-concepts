package com.example.ganesh.designpatterns.factory;

public class LuxuryCar extends Car {

    public LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Constructing Luxury Car!");
    }
}
