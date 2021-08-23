package com.example.ganesh.designpatterns.abstractfactory;

import com.example.ganesh.designpatterns.factory.CarType;

public class TestAbstractFactory {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.SMALL, Location.USA));
        System.out.println(CarFactory.buildCar(CarType.SEDAN, Location.ASIA));
        System.out.println(CarFactory.buildCar(CarType.LUXURY, Location.DEFAULT));
    }
}
