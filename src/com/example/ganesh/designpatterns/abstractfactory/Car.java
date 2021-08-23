package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public abstract class Car {

    private CarType model;
    private Location location;

    public Car(CarType model, Location location) {
        this.model = model;
        this.location = location;
    }

    protected abstract void construct();
}
