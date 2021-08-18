package com.example.ganesh.designpatterns.singleton;

public class LazyInitialization {

    private static volatile LazyInitialization instance = null;

    // private constructor
    private LazyInitialization() {
    }

    public static LazyInitialization getInstance() {
        if (instance == null) {
            synchronized (LazyInitialization.class) {
                instance = new LazyInitialization();
            }
        }
        return instance;
    }
}
