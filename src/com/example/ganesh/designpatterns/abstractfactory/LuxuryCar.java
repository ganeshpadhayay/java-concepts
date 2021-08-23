package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class LuxuryCar extends Car {

    public LuxuryCar(Location location) {
        super(CarType.LUXURY, location);
        construct();
    }

    @Override
    protected void construct() {
        System.out.println("Building luxury car");
    }
}
