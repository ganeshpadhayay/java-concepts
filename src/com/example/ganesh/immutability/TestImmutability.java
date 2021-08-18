package com.example.ganesh.immutability;

import java.util.Date;

public class TestImmutability {

    public static void main(String[] args) {
        ImmutableClass im = ImmutableClass.createNewInstance(100, "test", new Date());
        System.out.println(im);
        tryModification(im.getImmutableField1(), im.getImmutableField2(), im.getMutableField());
        System.out.println(im);
    }

    //this will not reflect as out class is an Immutable class
    private static void tryModification(Integer immutableField1, String immutableField2, Date mutableField) {
        immutableField1 = 10000;
        immutableField2 = "test changed";
        mutableField.setDate(10);
    }
}

/*

Immutable classes in JDK
Apart from your written classes, JDK itself has lots of immutable classes. Given is such a list of immutable classes in Java.

1. String
2. Wrapper classes such as Integer, Long, Double etc.
3. Immutable collection classes such as Collections.singletonMap() etc.
4. java.lang.StackTraceElement
5. Java enums (ideally they should be)
6. java.util.Locale
7. java.util.UUID

Benefits of making a class immutable
Lets first identify advantages of immutable class. In Java, immutable classes are:

1. are simple to construct, test, and use
2. are automatically thread-safe and have no synchronization issues
3. do not need a copy constructor
4. do not need an implementation of clone
5. allow hashCode() to use lazy initialization, and to cache its return value
6. do not need to be copied defensively when used as a field
7. make good Map keys and Set elements (these objects must not change state while in the collection)
8. have their class invariant established once upon construction, and it never needs to be checked again
9. always have “failure atomicity” (a term used by Joshua Bloch) : if an immutable object throws an exception, it’s never left in an undesirable or indeterminate state

 */
