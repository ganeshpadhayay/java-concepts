package com.example.ganesh.designpatterns.singleton.cloning;

public class SingletonCloningTest {
    
    public static void main(String[] args) throws CloneNotSupportedException {
        SingletonCloning instance1 = SingletonCloning.instance;
        SingletonCloning instance2 = (SingletonCloning) instance1.clone();
        System.out.println("instance1 hashCode:- " + instance1.hashCode());
        System.out.println("instance2 hashCode:- " + instance2.hashCode());
    }
}
