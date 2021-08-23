package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class SedanCar extends Car {

    public SedanCar(Location location) {
        super(CarType.SEDAN, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building sedan car");
    }
}
