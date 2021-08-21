package com.example.ganesh.designpatterns.singleton.serialization;

import java.io.Serializable;

public class SingletonSerialization implements Serializable, Cloneable {

    //This is required in cases where your class structure changes between serialization and deserialization.
    // A changed class structure will cause the JVM to give an exception in the de-serializing process.
    private static final long serialVersionUID = 1L;

    private volatile static SingletonSerialization instance = null;

    public static SingletonSerialization getInstance() {
        if (instance == null) {
            instance = new SingletonSerialization();
        }
        return instance;
    }

    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    //this method prevents the singleton breaking due to the serialization/deserialization
    protected Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return instance;
    }
}
