package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class USCarFactory {

    public static Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL: {
                car = new SmallCar(Location.USA);
                break;
            }
            case SEDAN: {
                car = new SedanCar(Location.USA);
                break;
            }
            case LUXURY: {
                car = new LuxuryCar(Location.USA);
                break;
            }
            default: {
                throw new IllegalArgumentException("No such car exists.");
            }
        }
        return car;
    }
}
