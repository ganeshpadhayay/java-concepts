package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class CarFactory {

    private CarFactory() {
        //Prevent instantiation
    }

    public static Car buildCar(CarType type, Location location) {
        Car car;

        switch (location) {
            case USA: {
                car = USCarFactory.buildCar(type);
                break;
            }
            case ASIA: {
                car = AsiaCarFactory.buildCar(type);
                break;
            }
            default: {
                car = DefaultCarFactory.buildCar(type);
            }
        }

        return car;
    }
}
