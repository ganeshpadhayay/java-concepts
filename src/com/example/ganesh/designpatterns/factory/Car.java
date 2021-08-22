package com.example.ganesh.designpatterns.factory;

public abstract class Car {

    //this will be provided by the client instantiating the car object
    private CarType model = null;

    public Car(CarType model) {
        this.model = model;
        arrangeParts(); //this method does some common work while instantiating the car object
    }

    private void arrangeParts() {
        // Do one time processing here, or maybe count the number of instances created here
    }

    // Do subclass level processing in this method
    protected abstract void construct();

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }
}
