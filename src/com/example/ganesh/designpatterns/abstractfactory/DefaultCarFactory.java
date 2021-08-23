package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class DefaultCarFactory {

    public static Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL: {
                car = new SmallCar(Location.DEFAULT);
                break;
            }
            case SEDAN: {
                car = new SedanCar(Location.DEFAULT);
                break;
            }
            case LUXURY: {
                car = new LuxuryCar(Location.DEFAULT);
                break;
            }
            default: {
                throw new IllegalArgumentException("No such car exists.");
            }
        }
        return car;
    }
}
