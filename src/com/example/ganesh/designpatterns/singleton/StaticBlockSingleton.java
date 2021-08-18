package com.example.ganesh.designpatterns.singleton;

public class StaticBlockSingleton {

    private static final StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("unexpected error: ", e);
        }
    }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }

    //private constructor
    private StaticBlockSingleton() {

    }
}
