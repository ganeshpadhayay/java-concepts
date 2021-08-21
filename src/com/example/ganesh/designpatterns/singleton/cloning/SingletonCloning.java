package com.example.ganesh.designpatterns.singleton.cloning;

public class SingletonCloning implements Cloneable {

    // public instance initialized when loading the class
    public static SingletonCloning instance = new SingletonCloning();

    private SingletonCloning() {
        // private constructor
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }
}
