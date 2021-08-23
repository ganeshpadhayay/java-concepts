package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class AsiaCarFactory {

    public static Car buildCar(CarType model) {
        Car car;
        switch (model) {
            case SMALL: {
                car = new SmallCar(Location.ASIA);
                break;
            }
            case SEDAN: {
                car = new SedanCar(Location.ASIA);
                break;
            }
            case LUXURY: {
                car = new LuxuryCar(Location.ASIA);
                break;
            }
            default: {
                throw new IllegalArgumentException("No such car exists.");
            }
        }
        return car;
    }
}
