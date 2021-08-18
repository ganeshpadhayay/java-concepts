package com.example.ganesh.designpatterns.singleton;

public class DCL {

    private static volatile DCL instance = null;

    // private constructor
    private DCL() {
    }

    public static DCL getInstance() {
        if (instance == null) {
            synchronized (DCL.class) {
                // Double check
                if (instance == null) {
                    instance = new DCL();
                }
            }
        }
        return instance;
    }
}
