package org.lucian.module2;

public class Car {
    @SuppressWarnings("unused")
    private final String brand;
    @SuppressWarnings("unused")
    private final String model;
    @SuppressWarnings("unused")
    private final int year;

    // constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Car(String brand, String model) {
        this(brand, model, 2025); // Default year to 2025
    }
}
