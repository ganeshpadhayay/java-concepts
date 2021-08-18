package com.example.ganesh.designpatterns.singleton;

/**
 * “Initialization-on-demand holder idiom”
 */
public class BillPughInnerClassSingleton {

    //private constructor
    private BillPughInnerClassSingleton() {
    }

    private static class LazyHolder {
        private static final BillPughInnerClassSingleton INSTANCE = new BillPughInnerClassSingleton();
    }

    public static BillPughInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
