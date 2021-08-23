package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class SmallCar extends Car {

    public SmallCar(Location location) {
        super(CarType.SMALL, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building small car");
    }
}
