package com.example.ganesh.designpatterns.factory;

public class CarFactory {

    public static Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL:
                car = new SmallCar();
                break;

            case SEDAN:
                car = new SedanCar();
                break;

            case LUXURY:
                car = new LuxuryCar();
                break;

            default:
                throw new IllegalArgumentException("No such car exist");
        }
        return car;
    }
}
