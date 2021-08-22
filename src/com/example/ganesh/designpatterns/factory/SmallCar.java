package com.example.ganesh.designpatterns.factory;

public class SmallCar extends Car {

    public SmallCar() {
        super(CarType.SMALL);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Constructing Small Car!");
    }
}
