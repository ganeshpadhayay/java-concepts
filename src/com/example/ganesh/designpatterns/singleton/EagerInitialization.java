package com.example.ganesh.designpatterns.singleton;

public class EagerInitialization {

    private static volatile EagerInitialization instance = new EagerInitialization();

    // private constructor
    private EagerInitialization() {
    }

    public static EagerInitialization getInstance() {
        return instance;
    }
}
