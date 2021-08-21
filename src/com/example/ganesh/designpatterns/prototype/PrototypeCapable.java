package com.example.ganesh.designpatterns.prototype;

public interface PrototypeCapable extends Cloneable {
    PrototypeCapable clone() throws CloneNotSupportedException;
}
