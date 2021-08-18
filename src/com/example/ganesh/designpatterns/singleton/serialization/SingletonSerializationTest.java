package com.example.ganesh.designpatterns.singleton.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializationTest {

    static SingletonSerialization instanceOne = SingletonSerialization.getInstance();

    public static void main(String[] args) {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instanceOne);
            out.close();

            instanceOne.setI(20);

            // Serialize to a file
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SingletonSerialization instanceTwo = (SingletonSerialization) in.readObject();
            in.close();

            System.out.println(instanceOne.getI());
            System.out.println(instanceTwo.getI());
            System.out.println("instance1 hashcode: " + instanceOne.hashCode() + " instance2 hashcode: " + instanceTwo.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
