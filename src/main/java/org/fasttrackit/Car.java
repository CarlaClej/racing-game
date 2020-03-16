package org.fasttrackit;

// "is-a" relationship / inheritance
public class Car extends AutoVehicle {

    int doorCount;

    public Car(Engine engine) {
        super(engine);
    }

    // constructor overLoading
    public Car() {
        super(new Engine());
    }
}
